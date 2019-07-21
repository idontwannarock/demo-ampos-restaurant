package com.example.demoamposrestaurant.presentation.payload;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class PageablePayload<T> implements Serializable {

    private static final long serialVersionUID = -8445059638943426824L;
    @ApiModelProperty(value = "Total pages.")
    private Integer totalPages;
    @ApiModelProperty(value = "Total elements.")
    private Long totalElements;
    @ApiModelProperty(value = "One slice of data.")
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
