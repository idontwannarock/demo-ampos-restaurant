package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "Class representing an item ordered in a request.")
public class OrderDetailRequestPayload implements Serializable {

    private static final long serialVersionUID = -4678965998544765833L;
    @ApiModelProperty(value = "Identifier of the ordered item", example = "1", position = 0)
    private Long itemId;
    @ApiModelProperty(value = "Quantity ordered", example = "2", position = 1)
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
