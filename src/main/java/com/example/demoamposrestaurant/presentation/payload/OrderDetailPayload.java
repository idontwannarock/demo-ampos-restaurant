package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OrderDetailPayload implements Serializable {

    private static final long serialVersionUID = 5433598483787424194L;
    @ApiModelProperty(value = "Order detail id")
    private Long id;
    @ApiModelProperty(value = "Ordered item id")
    private Long itemId;
    @ApiModelProperty(value = "Ordered quantity")
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
