package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Set;

public class MenuResponsePayload implements Serializable {

    private static final long serialVersionUID = -7971617173655531907L;
    @ApiModelProperty(value = "Menu id")
    private Long id;
    @ApiModelProperty(value = "Menu name")
    private String name;
    @ApiModelProperty(value = "Menu items")
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
