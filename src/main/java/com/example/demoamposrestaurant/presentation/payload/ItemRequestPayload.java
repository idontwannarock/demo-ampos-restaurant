package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

public class ItemRequestPayload implements Serializable {

    private static final long serialVersionUID = 3546271178544490448L;
    @ApiModelProperty(value = "Item name")
    private String name;
    @ApiModelProperty(value = "Item description")
    private String description;
    @ApiModelProperty(value = "Item image location")
    private String imageLocation;
    @ApiModelProperty(value = "Item price per unit")
    private BigDecimal price;
    @ApiModelProperty(value = "Item's type ids")
    private Set<Long> typeIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Long> getTypeIds() {
        return typeIds;
    }

    public void setTypeIds(Set<Long> typeIds) {
        this.typeIds = typeIds;
    }
}
