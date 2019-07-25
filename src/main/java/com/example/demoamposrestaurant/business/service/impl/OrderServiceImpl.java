package com.example.demoamposrestaurant.business.service.impl;

import com.example.demoamposrestaurant.business.converter.OrderConverter;
import com.example.demoamposrestaurant.business.converter.OrderDetailConverter;
import com.example.demoamposrestaurant.business.service.OrderService;
import com.example.demoamposrestaurant.persistent.domain.BillOrder;
import com.example.demoamposrestaurant.persistent.domain.Item;
import com.example.demoamposrestaurant.persistent.domain.OrderDetail;
import com.example.demoamposrestaurant.persistent.repository.BillOrderRepository;
import com.example.demoamposrestaurant.persistent.repository.ItemRepository;
import com.example.demoamposrestaurant.persistent.repository.OrderDetailRepository;
import com.example.demoamposrestaurant.presentation.payload.OrderDetailRequestPayload;
import com.example.demoamposrestaurant.presentation.payload.OrderResponsePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private BillOrderRepository orderRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderDetailRepository detailRepository;
    @Autowired
    private OrderDetailConverter detailConverter;
    @Autowired
    private OrderConverter orderConverter;

    @Override
    public long placeOrder(List<OrderDetailRequestPayload> payloads) {
        BillOrder order = new BillOrder();
        order.setIsChecked(false);
        orderRepository.save(order);

        Set<Long> itemIds = payloads.stream().mapToLong(OrderDetailRequestPayload::getItemId).boxed().collect(Collectors.toSet());
        List<Item> items = itemRepository.findAllById(itemIds);
        Date now = new Date();
        List<OrderDetail> details = payloads.stream()
                .map(payload -> detailConverter.toEntity(payload, order, items, now)).collect(Collectors.toList());

        detailRepository.saveAll(details);
        return order.getId();
    }

    @Override
    public OrderResponsePayload findOrderById(Long id) {
        return orderRepository.findById(id).map(orderConverter::toPayload)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such order."));
    }

    @Override
    public void checkTheBill(Long id) {
        BillOrder order = orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such order."));
        Set<OrderDetail> details = order.getDetails();
        Date checkedTime = new Date();
        details.forEach(d -> d.setCheckedTime(checkedTime));
        detailRepository.saveAll(details);
        order.setIsChecked(true);
        orderRepository.save(order);
    }

    @Override
    public long orderAdditionalItem(Long orderId, Long itemId, Integer quantity) {
        OrderDetail detail = new OrderDetail();
        detail.setBillOrder(orderRepository.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such order.")));
        detail.setOrderedTime(new Date());
        detail.setItem(itemRepository.findById(itemId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such item.")));
        detail.setQuantity(quantity);
        detailRepository.save(detail);
        return detail.getId();
    }

    @Override
    public void cancelOneItemInOrder(Long orderId, Long orderDetailId) {
        BillOrder order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such order."));
        Set<OrderDetail> details = order.getDetails();
        detailRepository.delete(details.stream()
                .filter(d -> Objects.equals(d.getId(), orderDetailId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such item in order.")));
        detailRepository.flush();
        if (details.stream().noneMatch(d -> d.getCheckedTime() == null)) {
            order.setIsChecked(true);
            orderRepository.save(order);
        }
    }
}
