package com.example.demoamposrestaurant.business.converter;

import com.example.demoamposrestaurant.persistent.domain.Menu;
import com.example.demoamposrestaurant.presentation.payload.MenuResponsePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MenuConverter {

    @Autowired
    private ItemConverter itemConverter;

    public MenuResponsePayload toPayload(Menu menu) {
        MenuResponsePayload payload = new MenuResponsePayload();
        payload.setId(menu.getId());
        Optional.ofNullable(menu.getName()).ifPresent(payload::setName);
        if (!menu.getItems().isEmpty()) {
            payload.setItems(menu.getItems().stream().map(itemConverter::toPayload).collect(Collectors.toSet()));
        }
        return payload;
    }

    public MenuResponsePayload toPayloadWithoutItems(Menu menu) {
        MenuResponsePayload payload = new MenuResponsePayload();
        payload.setId(menu.getId());
        Optional.ofNullable(menu.getName()).ifPresent(payload::setName);
        return payload;
    }
}
