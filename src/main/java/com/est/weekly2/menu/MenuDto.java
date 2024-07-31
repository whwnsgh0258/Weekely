package com.est.weekly2.menu;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link Menu}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuDto implements Serializable {

    private Long id;
    private String name;
    private String category;
    private Double price;
    private String description;

    public Menu toEntity() {
        return Menu.builder()
                .id(this.id)
                .name(this.name)
                .category(this.category)
                .price(this.price)
                .description(this.description)
                .build();
    }

    public static MenuDto toDto(Menu menu) {
        return MenuDto.builder()
                .id(menu.getId())
                .name(menu.getName())
                .category(menu.getCategory())
                .price(menu.getPrice())
                .description(menu.getDescription())
                .build();
    }
}