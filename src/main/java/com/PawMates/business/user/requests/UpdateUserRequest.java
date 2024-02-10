package com.PawMates.business.user.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateUserRequest extends CreateUserRequest {

    @NotBlank(message = "User ID cannot be null")
    private Long id;

    // Constructors, getters and setters are handled by Lombok
}
