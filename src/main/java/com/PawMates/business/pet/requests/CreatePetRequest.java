package com.PawMates.business.pet.requests;

import com.PawMates.entities.concretes.PetType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class CreatePetRequest {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    //@NotNull(message = "Pet type ID cannot be null")
    private Long typeId; // Changed to reference PetType by ID

    @NotBlank(message = "Breed cannot be blank")
    private String breed;

    @NotBlank(message = "Age cannot be blank")
    @Size(max = 20, message = "Age must be less than 20 characters")
    private String age;

    @NotBlank(message = "Gender cannot be blank")
    @Size(min = 1, max = 1, message = "Gender must be 'M' or 'F'")
    private String gender;

    private Long advertisementId; // Removed advertisement ID from pet creation

}
