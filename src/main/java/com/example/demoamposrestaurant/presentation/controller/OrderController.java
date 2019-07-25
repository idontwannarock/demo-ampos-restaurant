package com.example.demoamposrestaurant.presentation.controller;

import com.example.demoamposrestaurant.business.service.OrderService;
import com.example.demoamposrestaurant.presentation.payload.OrderDetailRequestPayload;
import com.example.demoamposrestaurant.presentation.payload.OrderResponsePayload;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Api(tags = "Endpoints for Managing Order")
@RequestMapping("api/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "Places an Order")
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity placeOrder(
            @ApiParam(value = "List of items to be ordered.", required = true)
            @RequestBody List<OrderDetailRequestPayload> items) {
        return ResponseEntity.created(URI.create("api/order/" + orderService.placeOrder(items))).build();
    }

    @ApiOperation(value = "Returns a Specific Order by Their Id")
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<OrderResponsePayload> findOrderById(
            @ApiParam(value = "Id of the order to be obtained.", required = true, example = "1")
            @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(orderService.findOrderById(id));
    }

    @ApiOperation(value = "Checks a Specific Bill by Their Order Id")
    @PutMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity check(
            @ApiParam(value = "Id of the order to be checked.", required = true, example = "1")
            @PathVariable(name = "id") Long id) {
        orderService.checkTheBill(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Adds Another Item to a Specific Order")
    @PostMapping(value = "/{orderId}/detail",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity orderAnotherItem(
            @ApiParam(value = "Id of the order to be added another item.", required = true, example = "1")
            @PathVariable(name = "orderId") Long orderId,
            @ApiParam(value = "Item and quantity to be added.", required = true)
            @RequestBody OrderDetailRequestPayload detail) {
        long detailId = orderService.orderAdditionalItem(orderId, detail.getItemId(), detail.getQuantity());
        return ResponseEntity.created(URI.create("api/order/" + orderId + "/detail/" + detailId)).build();
    }

    @ApiOperation(value = "Cancels an Item in a Specific Order")
    @DeleteMapping(value = "/{orderId}/detail/{detailId}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity cancelAnDetail(
            @ApiParam(value = "Id of the order, which contains the detail to be canceled.", required = true, example = "1")
            @PathVariable(name = "orderId") Long orderId,
            @ApiParam(value = "Id of the order detail to be canceled.", required = true, example = "3")
            @PathVariable(name = "detailId") Long detailId) {
        orderService.cancelAnDetailInOrder(orderId, detailId);
        return ResponseEntity.ok().build();
    }
}
