package com.est.weekly2.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menu")
public class MenuController {
    private final MenuService menuService;

    @GetMapping
    public ResponseEntity<List<MenuDto>> getAllMenus() {
        List<MenuDto> menuList = menuService.getAllMenus().stream()
                .map(MenuDto::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(menuList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuDto> getMenuById(@PathVariable Long id) {
        MenuDto menuDto = MenuDto.toDto(menuService.getMenuById(id));
        return new ResponseEntity<>(menuDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MenuDto> createMenu(@RequestBody MenuDto menuDto) {
        Menu menu = menuDto.toEntity();
        MenuDto createdMenu = MenuDto.toDto(menuService.createMenu(menu));
        return new ResponseEntity<>(createdMenu, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuDto> updateMenu(@PathVariable Long id, @RequestBody MenuDto menuDto) {
        Menu menu = menuDto.toEntity();
        menu.setId(id);
        MenuDto updatedMenu = MenuDto.toDto(menuService.updateMenu(menu));
        return new ResponseEntity<>(updatedMenu, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*@GetMapping("/search/category")
    public ResponseEntity<OrderDto> getMenuByCategory(@RequestParam String category){
        List<OrderDto> menuDtos = menuService.findMenuByCategory(category);
        return ResponseEntity.ok((OrderDto) menuDtos);
    }*/
}
