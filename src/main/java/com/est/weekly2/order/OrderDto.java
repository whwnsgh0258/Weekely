package com.est.weekly2.order;


import com.est.weekly2.customer.Customer;
import com.est.weekly2.customer.CustomerService;
import com.est.weekly2.store.StoreService;
import com.est.weekly2.store.Store;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DTO for {@link Order}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderDto implements Serializable {
    private Long id;
    private Long customerId;
    private Long storeId;
    private LocalDateTime orderDate;
    private String status;
    private List<OrderItemDto> items;

    public Order toEntity(CustomerService customerService, StoreService storeService) {
        Customer customer = customerService.getCustomerById(this.customerId);
        Store store = storeService.getStoreById(this.storeId);

        Order order = Order.builder()
                .id(this.id)
                .customer(customer)
                .store(store)
                .orderDate(this.orderDate)
                .status(this.status)
                .build();

        List<OrderItem> orderItems = this.items.stream()
                .map(itemDto -> itemDto.toEntity())
                .peek(item -> item.setOrder(order))
                .collect(Collectors.toList());
        order.setOrderItems(orderItems);

        return order;
    }

    public static OrderDto toDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .customerId(order.getCustomer().getId())
                .storeId(order.getStore().getId())
                .orderDate(order.getOrderDate())
                .status(order.getStatus())
                .items(order.getOrderItems().stream()
                        .map(OrderItemDto::toDto)
                        .collect(Collectors.toList()))
                .build();
    }
}