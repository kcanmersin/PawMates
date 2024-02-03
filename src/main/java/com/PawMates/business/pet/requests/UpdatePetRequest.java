package com.PawMates.business.pet.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePetRequest {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Type cannot be blank")
    private String type; // Köpek, kedi vb.

    @NotBlank(message = "Breed cannot be blank")
    private String breed; // Irk

    @NotBlank(message = "Age cannot be blank")
    @Size(max = 20, message = "Age must be less than 20 characters")
    private String age;

//    @NotBlank(message = "Location cannot be blank")
//    private String location; // Sahiplendirme veya kayıp ilanı için konum

    @NotBlank(message = "Gender cannot be blank")
    private String gender; // Cinsiyet
}