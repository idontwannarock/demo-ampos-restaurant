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

@Api(tags = "Endpoints for Managing Menu")
@RequestMapping("api/menu")
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "Creates a New Menu")
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity createMenu(
            @ApiParam(value = "Menu information of a menu to be created.", required = true)
            @RequestBody MenuRequestPayload menu) {
        return ResponseEntity.created(URI.create("api/menu/" + menuService.createNewMenu(menu))).build();
    }

    @ApiOperation(value = "Returns List of Available Menus Matching Against Optional Keyword")
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<MenuResponsePayload>> searchMenus(
            @ApiParam(value = "Optional keyword to match against menu name.", example = "Italian")
            @RequestParam(name = "keyword", required = false) String keyword) {
        return ResponseEntity.ok(menuService.searchMenuWithKeyword(keyword));
    }

    @ApiOperation(value = "Returns a Specific Menu by Their Id")
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MenuResponsePayload> findMenuById(
            @ApiParam(value = "Id of the menu to be obtained.", required = true, example = "1")
            @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(menuService.findMenuById(id));
    }

    @ApiOperation(value = "Modifies an Existing Menu",
            notes = "Properties that are not provided will be modified as empty value.")
    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity modifyMenu(
            @ApiParam(value = "Id of the menu to be modified.", required = true, example = "1")
            @PathVariable(name = "id") Long id,
            @ApiParam(value = "Menu to be modified with complete content.", required = true)
            @RequestBody MenuRequestPayload menu) {
        menuService.updateMenu(id, menu);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Disable a menu.")
    @DeleteMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity disableMenu(
            @ApiParam(value = "Id of the menu to be disabled.", required = true, example = "1")
            @PathVariable(name = "id") Long id) {
        menuService.disableMenu(id);
        return ResponseEntity.ok().build();
    }
}
