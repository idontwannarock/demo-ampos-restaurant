package com.example.demoamposrestaurant.presentation.controller;

import com.example.demoamposrestaurant.presentation.payload.ItemRequestPayload;
import com.example.demoamposrestaurant.presentation.payload.ItemResponsePayload;
import com.example.demoamposrestaurant.presentation.payload.PageablePayload;
import com.example.demoamposrestaurant.presentation.payload.TypePayload;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Api("Item Controller")
@RequestMapping("api/item")
@RestController
public class ItemController {

    @ApiOperation(value = "Get all item types.")
    @GetMapping(value = "/types",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<TypePayload>> getAllTypes() {
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "Create a new item.",
            notes = "Must provide name and price.")
    @PostMapping(value = "/",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createItem(
            @RequestBody ItemRequestPayload item) {
        return ResponseEntity.created(URI.create("api/item/")).build();
    }

    @ApiOperation(value = "Search items with pagination.",
            notes = "Keyword is optional, but provided keyword will match against item name, description, and additional details.")
    @GetMapping(value = "/",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PageablePayload<ItemResponsePayload>> searchItems(
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size) {
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "Find item by id.")
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ItemResponsePayload> findItemById(
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "Modify an existing item.",
            notes = "Must provide id of an existing item.\nProperties that are not provided will be modified as empty value.")
    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> modifyItem(
            @PathVariable("id") Long id,
            @RequestBody ItemRequestPayload item) {
        return ResponseEntity.ok().build();
    }
}
