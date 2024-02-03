package com.PawMates.business.pet.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPetsResponse {
    private Long id;
    private String name;
    private String type; // Köpek, kedi vb.
    private String breed; // Irk
    private String age;
//    private String location; // Sahiplendirme veya kayıp ilanı için konum
    private String gender; // Cinsiyet
}