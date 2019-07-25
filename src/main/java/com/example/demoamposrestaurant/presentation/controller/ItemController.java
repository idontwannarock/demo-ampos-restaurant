package com.example.demoamposrestaurant.presentation.controller;

import com.example.demoamposrestaurant.business.service.ItemService;
import com.example.demoamposrestaurant.business.service.TypeService;
import com.example.demoamposrestaurant.presentation.payload.ItemRequestPayload;
import com.example.demoamposrestaurant.presentation.payload.ItemResponsePayload;
import com.example.demoamposrestaurant.presentation.payload.PageablePayload;
import com.example.demoamposrestaurant.presentation.payload.TypePayload;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Api(tags = "Endpoints for Managing Item or Type")
@RequestMapping("api/item")
@RestController
public class ItemController {

    @Autowired
    private TypeService typeService;
    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "Returns List of All Item Types")
    @GetMapping(value = "/type",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<TypePayload>> getAllTypes() {
        return ResponseEntity.ok(typeService.getAllTypePayloads());
    }

    @ApiOperation(value = "Creates a New Item")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Item created.", responseHeaders = {@ResponseHeader(name = "location", response = String.class)})
    })
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity createItem(
            @ApiParam(value = "Item information for a new item to be created.", required = true)
            @RequestBody ItemRequestPayload item) {
        return ResponseEntity.created(URI.create("api/item/" + itemService.createNewItem(item))).build();
    }

    @ApiOperation(value = "Returns a Page of Items Matching Against Optional Keyword")
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PageablePayload<ItemResponsePayload>> searchItems(
            @ApiParam(value = "Optional keyword to match against item name, description, and additional details.", example = "Italian")
            @RequestParam(name = "keyword", required = false) String keyword,
            @ApiParam(value = "Page number of the results you want to fetch. Starts from 0.", required = true, example = " 0 ")
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @ApiParam(value = "Total number of the results on a specific page.", required = true, example = "10")
            @RequestParam(name = "size", defaultValue = "10") Integer size) {
        return ResponseEntity.ok(itemService.searchItemsWithKeywordAndPagination(keyword, page, size));
    }

    @ApiOperation(value = "Returns a Specific Item by Their Id")
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ItemResponsePayload> findItemById(
            @ApiParam(value = "Id of the item to be obtained.", required = true, example = "1")
            @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(itemService.findItemById(id));
    }

    @ApiOperation(value = "Modifies an Existing Item",
            notes = "Properties that are not provided will be modified as empty value.")
    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity modifyItem(
            @ApiParam(value = "Id of the item to be modified.", required = true, example = "1")
            @PathVariable(name = "id") Long id,
            @ApiParam(value = "Item information for an existing item to be modified.", required = true)
            @RequestBody ItemRequestPayload item) {
        itemService.updateItem(id, item);
        return ResponseEntity.ok().build();
    }
}
