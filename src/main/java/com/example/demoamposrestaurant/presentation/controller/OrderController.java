package com.example.demoamposrestaurant.presentation.controller;

import com.example.demoamposrestaurant.presentation.payload.OrderDetailPayload;
import com.example.demoamposrestaurant.presentation.payload.OrderResponsePayload;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Api("Order Controller")
@RequestMapping("api/order")
@RestController
public class OrderController {

    @ApiOperation(value = "Place an order.")
    @PostMapping(value = "/",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> placeOrder(
            @RequestBody List<OrderDetailPayload> order) {
        return ResponseEntity.created(URI.create("api/order/{id}")).build();
    }

    @ApiOperation(value = "Find order by id.")
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<OrderResponsePayload> findOrderById(
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "Check the bill.")
    @PutMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> check(
            @PathVariable("id") Long id) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Add another item to the order.")
    @PostMapping(value = "/{orderId}/detail",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> orderAnotherItem(
            @PathVariable("orderId") Long orderId,
            @RequestBody OrderDetailPayload detail) {
        return ResponseEntity.created(URI.create("api/order/{orderId}/detail/{detailId}")).build();
    }

    @ApiOperation(value = "Cancel an item in the order.")
    @DeleteMapping(value = "/{orderId}/detail/{detailId}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> cancelAnItem(
            @PathVariable("orderId") Long orderId,
            @PathVariable("detailId") Long detailId) {
        return ResponseEntity.ok().build();
    }
}
