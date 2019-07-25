package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "Class representing an order detail in a response.")
public class OrderDetailResponsePayload implements Serializable {

    private static final long serialVersionUID = 864638097153539539L;
    @ApiModelProperty(value = "Identifier of the order detail", position = 0)
    private Long id;
    @ApiModelProperty(value = "Item ordered", position = 1)
    private ItemResponsePayload item;
    @ApiModelProperty(value = "Quantity ordered", position = 2)
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
