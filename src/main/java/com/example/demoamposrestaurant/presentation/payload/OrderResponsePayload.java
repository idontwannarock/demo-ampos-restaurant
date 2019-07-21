package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

public class OrderResponsePayload implements Serializable {

    private static final long serialVersionUID = -2677598212683361559L;
    @ApiModelProperty(value = "Order id")
    private Long id;
    @ApiModelProperty(value = "Total amount of the order")
    private BigDecimal totalAmount;
    @ApiModelProperty(value = "List of ordered items")
    private Set<OrderDetailResponsePayload> details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Set<OrderDetailResponsePayload> getDetails() {
        return details;
    }

    public void setDetails(Set<OrderDetailResponsePayload> details) {
        this.details = details;
    }
}
