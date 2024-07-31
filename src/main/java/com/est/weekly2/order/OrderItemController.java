package com.est.weekly2.order;/*
package com.example.demo.Weekly.order;

import com.example.demo.Weekly.store.StoreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
@RequiredArgsConstructor
public class OrderItemController {
    private final OrderItemService orderItemService;


    @PostMapping
    public ResponseEntity<OrderItemDto> createStore(@RequestBody OrderItemDto orderItemDto) {
        OrderItemDto createdOrder = orderItemService.createOrderItem(orderItemDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDto> getStoreById(@PathVariable Long id) {
        return orderItemService.getOrderItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<OrderItemDto>> getAllStores() {
        List<StoreDto> stores = orderItemService.getAllOrderItem();
        return ResponseEntity.ok(stores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemDto> updateStore(@PathVariable Long id, @RequestBody StoreDto storeDto) {
        return orderItemService.updateOrderItemById(id, storeDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        boolean deleteOrderItem = orderItemService.deleteOrderItemById(id);
        return deleteOrderItem ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
*/
