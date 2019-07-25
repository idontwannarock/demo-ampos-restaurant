package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@ApiModel(description = "Class representing an item in request.")
public class ItemRequestPayload implements Serializable {

    private static final long serialVersionUID = 3546271178544490448L;
    @ApiModelProperty(value = "Item name", example = "Pizza Margherita", position = 0)
    private String name;
    @ApiModelProperty(value = "Item description", example = "A typical Neapolitan pizza, made with San Marzano tomatoes, mozzarella cheese, fresh basil, salt and extra-virgin olive oil.", position = 1)
    private String description;
    @ApiModelProperty(value = "Item image location", example = "https://i.pinimg.com/originals/fd/34/b0/fd34b03d5d936a024248d0eef5eeee1b.jpg", position = 2)
    private String imageLocation;
    @ApiModelProperty(value = "Item price per unit", example = "400", position = 4)
    private BigDecimal price;
    @ApiModelProperty(value = "Identifiers of item types", example = "[1]", position = 5)
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
