package com.example.demoamposrestaurant.business.service;

import com.example.demoamposrestaurant.presentation.payload.OrderDetailRequestPayload;
import com.example.demoamposrestaurant.presentation.payload.OrderResponsePayload;

import java.util.List;

public interface OrderService {

    long placeOrder(List<OrderDetailRequestPayload> payloads);

    OrderResponsePayload findOrderById(Long id);

    void checkTheBill(Long id);

    long orderAdditionalItem(Long orderId, Long itemId, Integer quantity);

    void cancelOneItemInOrder(Long orderId, Long orderDetailId);
}
