package com.example.demoamposrestaurant.business.service.impl;

import com.example.demoamposrestaurant.business.converter.MenuConverter;
import com.example.demoamposrestaurant.business.service.MenuService;
import com.example.demoamposrestaurant.persistent.domain.Menu;
import com.example.demoamposrestaurant.persistent.repository.ItemRepository;
import com.example.demoamposrestaurant.persistent.repository.MenuRepository;
import com.example.demoamposrestaurant.presentation.payload.MenuRequestPayload;
import com.example.demoamposrestaurant.presentation.payload.MenuResponsePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private MenuConverter menuConverter;

    @Override
    public long createNewMenu(MenuRequestPayload payload) {
        Menu menu = new Menu();
        Optional.ofNullable(payload.getName()).ifPresent(menu::setName);
        menu.setIsAvailable(true);
        Optional.ofNullable(payload.getIsAvailable()).ifPresent(menu::setIsAvailable);

        Set<Long> itemIds = payload.getItemIds();
        if (itemIds != null && itemIds.size() > 0) {
            menu.setItems(new HashSet<>(itemRepository.findAllById(itemIds)));
        }

        menuRepository.save(menu);
        return menu.getId();
    }

    @Override
    public List<MenuResponsePayload> searchMenuWithKeyword(String keyword) {
        List<Menu> menus;
        if (keyword != null && keyword.length() > 0 && keyword.trim().length() > 0) {
            menus = menuRepository.findByIsAvailableTrueAndNameContaining(keyword);
        } else {
            menus = menuRepository.findByIsAvailableTrue();
        }
        return menus.stream().map(menuConverter::toPayloadWithoutItems).collect(Collectors.toList());
    }

    @Override
    public MenuResponsePayload findMenuById(Long id) {
        return menuRepository.findById(id).map(menuConverter::toPayload)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such menu."));
    }

    @Override
    public void updateMenu(Long id, MenuRequestPayload payload) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such menu."));

        menu.setName(payload.getName());
        menu.setIsAvailable(payload.getIsAvailable());
        Set<Long> itemIds = payload.getItemIds();
        if (itemIds != null && itemIds.size() > 0) {
            menu.setItems(new HashSet<>(itemRepository.findAllById(itemIds)));
        }
        menuRepository.save(menu);
    }

    @Override
    public void disableMenu(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such menu."));
        menu.setIsAvailable(false);
        menuRepository.save(menu);
    }
}
