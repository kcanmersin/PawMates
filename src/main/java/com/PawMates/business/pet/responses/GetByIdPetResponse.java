package com.PawMates.business.pet.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdPetResponse {
    private Long id;
    private String name;
    private Long typeId; // To include the pet's type ID
    private String typeName; // Köpek, kedi vb.
    private String breed; // Irk
    private String age;
//    private String location; // Sahiplendirme veya kayıp ilanı için konum
    private String gender; // Cinsiyet
}