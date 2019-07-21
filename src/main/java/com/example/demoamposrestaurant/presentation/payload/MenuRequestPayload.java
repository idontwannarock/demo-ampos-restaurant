package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Set;

public class MenuRequestPayload implements Serializable {

    private static final long serialVersionUID = -2830999082696129737L;
    @ApiModelProperty(value = "Menu name")
    private String name;
    @ApiModelProperty(value = "Menu items")
    private Set<Long> itemIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(Set<Long> itemIds) {
        this.itemIds = itemIds;
    }
}
