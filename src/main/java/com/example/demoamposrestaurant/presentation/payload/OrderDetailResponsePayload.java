package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OrderDetailResponsePayload implements Serializable {

    private static final long serialVersionUID = 864638097153539539L;
    @ApiModelProperty(value = "Order detail id")
    private Long id;
    @ApiModelProperty(value = "Ordered item")
    private ItemResponsePayload item;
    @ApiModelProperty(value = "Ordered quantity")
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemResponsePayload getItem() {
        return item;
    }

    public void setItem(ItemResponsePayload item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
