package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class TypePayload implements Serializable {

    private static final long serialVersionUID = 6806062897840186282L;
    @ApiModelProperty(value = "item type id")
    private Long id;
    @ApiModelProperty(value = "item type name")
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
