package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

public class ItemResponsePayload implements Serializable {

    private static final long serialVersionUID = 1580270042701659021L;
    @ApiModelProperty(value = "Item id")
    private Long id;
    @ApiModelProperty(value = "Item name")
    private String name;
    @ApiModelProperty(value = "Item description")
    private String description;
    @ApiModelProperty(value = "Item image location")
    private String imageLocation;
    @ApiModelProperty(value = "Item price per unit")
    private BigDecimal price;
    @ApiModelProperty(value = "Item's additional details")
    private Set<TypePayload> types;

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

    public Set<TypePayload> getTypes() {
        return types;
    }

    public void setTypes(Set<TypePayload> types) {
        this.types = types;
    }
}
