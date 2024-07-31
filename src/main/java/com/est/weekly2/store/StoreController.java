package com.est.weekly2.store;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping
    public ResponseEntity<List<StoreDto>> getAllStores() {
        List<StoreDto> storeList = storeService.getAllStores().stream()
                .map(StoreDto::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(storeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDto> getStoreById(@PathVariable Long id) {
        StoreDto storeDto = StoreDto.toDto(storeService.getStoreById(id));
        return new ResponseEntity<>(storeDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StoreDto> createStore(@RequestBody StoreDto storeDto) {
        Store store = storeDto.toEntity();
        StoreDto createdStore = StoreDto.toDto(storeService.createStore(store));
        return new ResponseEntity<>(createdStore, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreDto> updateStore(@PathVariable Long id, @RequestBody StoreDto storeDto) {
        Store store = storeDto.toEntity();
        store.setId(id);
        StoreDto updatedStore = StoreDto.toDto(storeService.updateStore(store));
        return new ResponseEntity<>(updatedStore, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}