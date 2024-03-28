package com.PawMates.business.pet.requests;

import jakarta.annotation.Nullable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
public class CreatePetRequest {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    private Long typeId;

    @NotBlank(message = "Breed cannot be blank")
    private String breed;

    @NotBlank(message = "Age cannot be blank")
    @Size(max = 20, message = "Age must be less than 20 characters")
    private String age;

    @NotBlank(message = "Gender cannot be blank")
    @Size(min = 1, max = 1, message = "Gender must be 'M' or 'F'")
    private String gender;

    @Nullable
    private Long advertisementId;
    // MultipartFile tipinde bir veya birden fazla resim ekleyin
   // private MultipartFile[] petImages; // Birden fazla resim desteklemek için MultipartFile dizisi
//    private List<PetImage> petImages;
    
}
