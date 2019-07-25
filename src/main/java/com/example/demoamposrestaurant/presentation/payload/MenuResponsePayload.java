package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Set;

@ApiModel(description = "Class representing a menu in response.")
public class MenuResponsePayload implements Serializable {

    private static final long serialVersionUID = -7971617173655531907L;
    @ApiModelProperty(value = "Identifier of the menu", position = 0)
    private Long id;
    @ApiModelProperty(value = "Menu name", position = 1)
    private String name;
    @ApiModelProperty(value = "Items in the menu", position = 2)
    private Set<ItemResponsePayload> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ItemResponsePayload> getItems() {
        return items;
    }

    public void setItems(Set<ItemResponsePayload> items) {
        this.items = items;
    }
}
