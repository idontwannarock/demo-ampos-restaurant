package com.example.demoamposrestaurant.business.service.impl;

import com.example.demoamposrestaurant.business.converter.ItemConverter;
import com.example.demoamposrestaurant.business.service.ItemService;
import com.example.demoamposrestaurant.persistent.domain.Item;
import com.example.demoamposrestaurant.persistent.repository.ItemRepository;
import com.example.demoamposrestaurant.persistent.repository.TypeRepository;
import com.example.demoamposrestaurant.presentation.payload.ItemRequestPayload;
import com.example.demoamposrestaurant.presentation.payload.ItemResponsePayload;
import com.example.demoamposrestaurant.presentation.payload.PageablePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private ItemConverter itemConverter;

    @Override
    public long createNewItem(ItemRequestPayload payload) {
        Item item = itemConverter.toEntity(payload);

        Set<Long> typeIds = payload.getTypeIds();
        if (typeIds != null && !typeIds.isEmpty()) {
            item.setTypes(new HashSet<>(typeRepository.findAllById(typeIds)));
        }

        itemRepository.save(item);
        return item.getId();
    }

    @Override
    public PageablePayload<ItemResponsePayload> searchItemsWithKeywordAndPagination(String keyword, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        Page<Item> result;
        if (keyword != null && keyword.length() > 0 && keyword.trim().length() > 0) {
            result = itemRepository.findByNameContainingOrDescriptionContainingOrTypes_NameContaining(keyword, keyword, keyword, pageRequest);
        } else {
            result = itemRepository.findAll(pageRequest);
        }

        PageablePayload<ItemResponsePayload> payload = new PageablePayload<>();
        payload.setData(result.get().map(itemConverter::toPayload).collect(Collectors.toList()));
        payload.setTotalPages(result.getTotalPages());
        payload.setTotalElements(result.getTotalElements());
        return payload;
    }

    @Override
    public ItemResponsePayload findItemById(Long id) {
        return itemRepository.findById(id).map(itemConverter::toPayload)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such item."));
    }

    @Override
    public void updateItem(Long id, ItemRequestPayload payload) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such item."));

        item.setName(payload.getName());
        item.setDescription(payload.getDescription());
        item.setImageLocation(payload.getImageLocation());
        item.setPrice(payload.getPrice());

        Set<Long> typeIds = payload.getTypeIds();
        if (typeIds != null && !typeIds.isEmpty()) {
            item.setTypes(new HashSet<>(typeRepository.findAllById(typeIds)));
        }
        itemRepository.save(item);
    }
}
