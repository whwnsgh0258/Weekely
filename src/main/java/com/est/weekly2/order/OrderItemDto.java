package com.est.weekly2.order;



import com.est.weekly2.menu.MenuDto;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link OrderItem}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderItemDto implements Serializable {
    private Long id;
    private MenuDto menu;
    private Long quantity;
    private Double totalPrice;

    public OrderItem toEntity() {
        return OrderItem.builder()
                .id(this.id)
                .menu(this.menu.toEntity())
                .quantity(this.quantity)
                .totalPrice(this.totalPrice)
                .build();
    }

    public static OrderItemDto toDto(OrderItem orderItem) {
        return OrderItemDto.builder()
                .id(orderItem.getId())
                .menu(MenuDto.toDto(orderItem.getMenu()))
                .quantity(orderItem.getQuantity())
                .totalPrice(orderItem.getTotalPrice())
                .build();
    }
}