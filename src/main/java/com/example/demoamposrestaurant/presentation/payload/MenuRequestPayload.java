package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Set;

@ApiModel(description = "Class representing a menu in request.")
public class MenuRequestPayload implements Serializable {

    private static final long serialVersionUID = -530162216776145870L;
    @ApiModelProperty(value = "Menu name", example = "Today's special", position = 0)
    private String name;
    @ApiModelProperty(value = "Availability of the menu", example = "true", position = 1)
    private Boolean isAvailable;
    @ApiModelProperty(value = "Menu items", example = "[1, 3, 5]", position = 2)
    private Set<Long> itemIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Set<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(Set<Long> itemIds) {
        this.itemIds = itemIds;
    }
}
