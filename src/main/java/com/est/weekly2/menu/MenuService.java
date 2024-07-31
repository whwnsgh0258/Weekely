package com.est.weekly2.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    @Transactional(readOnly = true)
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Menu getMenuById(Long id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id+ "번의 메뉴를 찾을 수 없습니다."));
    }

    @Transactional
    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Transactional
    public Menu updateMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Transactional
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
    /*@Transactional(readOnly = true)
    public List<OrderDto> findMenuByCategory(String category) {
        List<OrderDto> collect = menuRepository.findMenuByCategory(category).stream()
                .map((OrderDto menu) -> OrderDto.toDTO(menu.toEntity()))
                .collect(Collectors.toList());
        return collect;
    }*/
}
