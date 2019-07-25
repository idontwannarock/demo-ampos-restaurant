package com.example.demoamposrestaurant.business.converter;

import com.example.demoamposrestaurant.persistent.domain.BillOrder;
import com.example.demoamposrestaurant.persistent.domain.Item;
import com.example.demoamposrestaurant.persistent.domain.OrderDetail;
import com.example.demoamposrestaurant.presentation.payload.OrderDetailRequestPayload;
import com.example.demoamposrestaurant.presentation.payload.OrderDetailResponsePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class OrderDetailConverter {

    @Autowired
    private ItemConverter itemConverter;

    public OrderDetail toEntity(OrderDetailRequestPayload payload, BillOrder order, List<Item> items, Date orderedTime) {
        OrderDetail detail = new OrderDetail();
        detail.setBillOrder(order);
        items.stream().filter(i -> Objects.equals(i.getId(), payload.getItemId())).findFirst().ifPresent(detail::setItem);
        detail.setQuantity(payload.getQuantity());
        detail.setOrderedTime(orderedTime);
        return detail;
    }

    public OrderDetailResponsePayload toPayload(OrderDetail detail) {
        OrderDetailResponsePayload payload = new OrderDetailResponsePayload();
        payload.setId(detail.getId());
        payload.setItem(itemConverter.toPayload(detail.getItem()));
        payload.setQuantity(detail.getQuantity());
        return payload;
    }
}
