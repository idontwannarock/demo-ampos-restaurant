package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OrderDetailRequestPayload implements Serializable {

    private static final long serialVersionUID = -4678965998544765833L;
    @ApiModelProperty(value = "Ordered item id")
    private Long itemId;
    @ApiModelProperty(value = "Ordered quantity")
    private Integer quantity;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
