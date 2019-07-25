package com.example.demoamposrestaurant.presentation.controller;

import com.example.demoamposrestaurant.business.service.ItemService;
import com.example.demoamposrestaurant.business.service.TypeService;
import com.example.demoamposrestaurant.presentation.payload.ItemRequestPayload;
import com.example.demoamposrestaurant.presentation.payload.ItemResponsePayload;
import com.example.demoamposrestaurant.presentation.payload.PageablePayload;
import com.example.demoamposrestaurant.presentation.payload.TypePayload;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Api("Item Controller")
@RequestMapping("api/item")
@RestController
public class ItemController {

    @Autowired
    private TypeService typeService;
    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "Get all item types.")
    @GetMapping(value = "/types",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<TypePayload>> getAllTypes() {
        return ResponseEntity.ok(typeService.getAllTypePayloads());
    }

    @ApiOperation(value = "Create a new item.",
            notes = "Must provide name and price.")
    @PostMapping(value = "/",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity createItem(
            @ApiParam("Content of a new item.")
            @RequestBody ItemRequestPayload item) {
        long itemId = itemService.createNewItem(item);
        return ResponseEntity.created(URI.create("api/item/" + itemId)).build();
    }

    @ApiOperation(value = "Search items with pagination.",
            notes = "Page parameter starts from 0.")
    @GetMapping(value = "/",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PageablePayload<ItemResponsePayload>> searchItems(
            @ApiParam("Optional keyword to match against item name, description, and additional details.")
            @RequestParam(name = "keyword", required = false) String keyword,
            @ApiParam("Page number of the results you want to fetch. Start from 0.")
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @ApiParam("Total number of the results on a specific page.")
            @RequestParam(name = "size", defaultValue = "10") Integer size) {
        return ResponseEntity.ok(itemService.searchItemsWithKeywordAndPagination(keyword, page, size));
    }

    @ApiOperation(value = "Find item by id.")
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ItemResponsePayload> findItemById(
            @ApiParam(value = "Item's id to be found.", required = true)
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(itemService.findItemById(id));
    }

    @ApiOperation(value = "Modify an existing item.",
            notes = "Must provide id of an existing item.\nProperties that are not provided will be modified as empty value.")
    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity modifyItem(
            @ApiParam(value = "Item's id to be modify.", required = true)
            @PathVariable("id") Long id,
            @ApiParam("Item to be modified with complete content.")
            @RequestBody ItemRequestPayload item) {
        itemService.updateItem(id, item);
        return ResponseEntity.ok().build();
    }
}
