package com.est.weekly2.store;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link Store}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StoreDto implements Serializable {
    private Long id;
    private String name;
    private String phoneNumber;
    private String address;

    public Store toEntity() {
        return Store.builder()
                .id(this.id)
                .name(this.name)
                .phoneNumber(this.phoneNumber)
                .address(this.address)
                .build();
    }

    public static StoreDto toDto(Store store) {
        return StoreDto.builder()
                .id(store.getId())
                .name(store.getName())
                .phoneNumber(store.getPhoneNumber())
                .address(store.getAddress())
                .build();
    }
}