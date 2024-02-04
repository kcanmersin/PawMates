package com.PawMates.business.petType.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePetTypeRequest {
    @NotNull(message = "Pet type ID cannot be null")
    private Long id;

    @NotBlank(message = "Type name cannot be blank")
    @Size(min = 1, max = 50, message = "Type name must be between 1 and 50 characters")
    private String name;
}
