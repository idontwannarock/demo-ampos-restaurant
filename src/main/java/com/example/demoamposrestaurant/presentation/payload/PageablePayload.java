package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "Class representing a page of results.")
public class PageablePayload<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -8445059638943426824L;
    @ApiModelProperty(value = "Total pages.", position = 0)
    private Integer totalPages;
    @ApiModelProperty(value = "Total elements.", position = 1)
    private Long totalElements;
    @ApiModelProperty(value = "One page of data.", position = 2)
    private List<T> data;

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
