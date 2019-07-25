package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@ApiModel(description = "Class representing an item in response.")
public class ItemResponsePayload implements Serializable {

    private static final long serialVersionUID = 1580270042701659021L;
    @ApiModelProperty(value = "Identifier of the item", position = 0)
    private Long id;
    @ApiModelProperty(value = "Item name", position = 1)
    private String name;
    @ApiModelProperty(value = "Item description", position = 2)
    private String description;
    @ApiModelProperty(value = "Item image location", position = 3)
    private String imageLocation;
    @ApiModelProperty(value = "Item price per unit", position = 4)
    private BigDecimal price;
    @ApiModelProperty(value = "Item types (additional details)", position = 5)
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
