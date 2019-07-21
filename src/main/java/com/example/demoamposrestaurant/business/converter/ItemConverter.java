package com.example.demoamposrestaurant.business.converter;

import com.example.demoamposrestaurant.persistent.domain.Item;
import com.example.demoamposrestaurant.presentation.payload.ItemRequestPayload;
import com.example.demoamposrestaurant.presentation.payload.ItemResponsePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ItemConverter {

    @Autowired
    private TypeConverter typeConverter;

    public Item toEntity(ItemRequestPayload payload) {
        Item item = new Item();
        Optional.ofNullable(payload.getName()).ifPresent(item::setName);
        Optional.ofNullable(payload.getDescription()).ifPresent(item::setDescription);
        Optional.ofNullable(payload.getImageLocation()).ifPresent(item::setImageLocation);
        Optional.ofNullable(payload.getPrice()).ifPresent(item::setPrice);
        return item;
    }

    public ItemResponsePayload toPayload(Item item) {
        ItemResponsePayload payload = new ItemResponsePayload();
        Optional.ofNullable(item.getId()).ifPresent(payload::setId);
        Optional.ofNullable(item.getName()).ifPresent(payload::setName);
        Optional.ofNullable(item.getDescription()).ifPresent(payload::setDescription);
        Optional.ofNullable(item.getImageLocation()).ifPresent(payload::setImageLocation);
        Optional.ofNullable(item.getPrice()).ifPresent(payload::setPrice);
        if (!item.getTypes().isEmpty()) {
            payload.setTypes(item.getTypes().stream().map(typeConverter::toPayload).collect(Collectors.toSet()));
        }
        return payload;
    }
}
