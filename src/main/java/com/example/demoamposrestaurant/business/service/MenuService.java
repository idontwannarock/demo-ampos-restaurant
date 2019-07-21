package com.example.demoamposrestaurant.business.service;

import com.example.demoamposrestaurant.presentation.payload.MenuRequestPayload;
import com.example.demoamposrestaurant.presentation.payload.MenuResponsePayload;

import java.util.List;

public interface MenuService {

    long createNewMenu(MenuRequestPayload payload);

    List<MenuResponsePayload> searchMenuWithKeyword(String keyword);

    MenuResponsePayload findMenuById(Long id);

    void updateMenu(Long id, MenuRequestPayload payload);

    void disableMenu(Long id);
}
