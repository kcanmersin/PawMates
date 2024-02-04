package com.PawMates.business.address.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateAddressRequest extends CreateAddressRequest {
    @NotNull(message = "Address ID cannot be null")
    private Long id;
}
