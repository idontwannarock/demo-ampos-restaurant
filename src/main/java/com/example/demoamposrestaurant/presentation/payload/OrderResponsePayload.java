package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@ApiModel(description = "Class representing an order in a response.")
public class OrderResponsePayload implements Serializable {

    private static final long serialVersionUID = -2677598212683361559L;
    @ApiModelProperty(value = "Identifier of the order", position = 0)
    private Long id;
    @ApiModelProperty(value = "Total amount of the order", position = 1)
    private BigDecimal totalAmount;
    @ApiModelProperty(value = "List of ordered items", position = 2)
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
