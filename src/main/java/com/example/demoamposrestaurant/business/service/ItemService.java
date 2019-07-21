package com.example.demoamposrestaurant.business.service;

import com.example.demoamposrestaurant.presentation.payload.ItemRequestPayload;
import com.example.demoamposrestaurant.presentation.payload.ItemResponsePayload;
import com.example.demoamposrestaurant.presentation.payload.PageablePayload;

public interface ItemService {

    long createNewItem(ItemRequestPayload payload);

    PageablePayload<ItemResponsePayload> searchItemsWithKeywordAndPagination(String keyword, Integer page, Integer size);

    ItemResponsePayload findItemById(Long id);

    void updateItem(Long id, ItemRequestPayload payload);
}
