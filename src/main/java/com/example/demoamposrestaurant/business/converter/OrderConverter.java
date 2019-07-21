package com.example.demoamposrestaurant.business.converter;

import com.example.demoamposrestaurant.persistent.domain.BillOrder;
import com.example.demoamposrestaurant.persistent.domain.OrderDetail;
import com.example.demoamposrestaurant.presentation.payload.OrderResponsePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OrderConverter {

    @Autowired
    private OrderDetailConverter detailConverter;

    public OrderResponsePayload toPayload(BillOrder order) {
        OrderResponsePayload payload = new OrderResponsePayload();
        payload.setId(order.getId());
        if (!order.getDetails().isEmpty()) {
            Set<OrderDetail> details = order.getDetails();
            payload.setDetails(details.stream().map(detailConverter::toPayload).collect(Collectors.toSet()));
            payload.setTotalAmount(details.stream()
                    .map(d -> d.getItem().getPrice().multiply(new BigDecimal(d.getQuantity())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add));
        }
        return payload;
    }
}
