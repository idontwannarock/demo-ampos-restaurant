package com.example.demoamposrestaurant.presentation.controller;

import com.example.demoamposrestaurant.business.service.MenuService;
import com.example.demoamposrestaurant.presentation.payload.MenuRequestPayload;
import com.example.demoamposrestaurant.presentation.payload.MenuResponsePayload;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Api("Menu Controller")
@RequestMapping("api/menu")
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "Create a new menu.")
    @PostMapping(value = "/",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createMenu(
            @ApiParam("Content of a new menu.")
            @RequestBody MenuRequestPayload menu) {
        return ResponseEntity.created(URI.create("api/menu/" + menuService.createNewMenu(menu))).build();
    }

    @ApiOperation(value = "Search available menus.",
            notes = "Provided keyword will match against menu name.\nOtherwise return all available menus.")
    @GetMapping(value = "/",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<MenuResponsePayload>> searchMenus(
            @ApiParam("Optional keyword to match against menu name.")
            @RequestParam(name = "keyword", required = false) String keyword) {
        return ResponseEntity.ok(menuService.searchMenuWithKeyword(keyword));
    }

    @ApiOperation(value = "Find menu by id.")
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MenuResponsePayload> findMenuById(
            @ApiParam(value = "Menu's id to be found.", required = true)
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(menuService.findMenuById(id));
    }

    @ApiOperation(value = "Modify an existing menu.",
            notes = "Must provide id of an existing menu.\nProperties that are not provided will be modified as empty value.")
    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> modifyMenu(
            @ApiParam(value = "Menu's id to be modify.", required = true)
            @PathVariable("id") Long id,
            @ApiParam("Menu to be modified with complete content.")
            @RequestBody MenuRequestPayload menu) {
        menuService.updateMenu(id, menu);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Disable a menu.")
    @DeleteMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> disableMenu(
            @ApiParam(value = "Menu's id to be disabled.", required = true)
            @PathVariable("id") Long id) {
        menuService.disableMenu(id);
        return ResponseEntity.ok().build();
    }
}
