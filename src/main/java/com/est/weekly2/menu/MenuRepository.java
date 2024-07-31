package com.est.weekly2.menu;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<MenuDto> findMenuByCategory(String category);
}
