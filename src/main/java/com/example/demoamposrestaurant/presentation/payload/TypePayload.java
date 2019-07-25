package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "Class representing a type(additional detail) of items.")
public class TypePayload implements Serializable {

    private static final long serialVersionUID = 6806062897840186282L;
    @ApiModelProperty(value = "Unique identifier of the item type(additional detail).", example = "1", position = 0)
    private Long id;
    @ApiModelProperty(value = "Name of the item type(additional detail).", example = "Italian", position = 1)
    private String name;

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
}
