package com.est.weekly2.customer;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link Customer}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDto implements Serializable {
    private Long id;
    private String name;
    private String phoneNumber;
    private String address;

    public Customer toEntity() {
        return Customer.builder()
                .id(this.id)
                .name(this.name)
                .phoneNumber(this.phoneNumber)
                .address(this.address)
                .build();
    }

    public static CustomerDto toDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .phoneNumber(customer.getPhoneNumber())
                .address(customer.getAddress())
                .build();
    }
}