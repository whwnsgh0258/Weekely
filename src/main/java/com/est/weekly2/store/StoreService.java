package com.est.weekly2.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    @Transactional(readOnly = true)
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Store getStoreById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found"));
    }

    @Transactional
    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    @Transactional
    public Store updateStore(Store store) {
        return storeRepository.save(store);
    }

    @Transactional
    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }
}
