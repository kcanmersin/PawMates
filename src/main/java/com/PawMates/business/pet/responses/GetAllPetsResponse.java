package com.PawMates.business.pet.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPetsResponse {
    private Long id;
    private String name;
    private Long typeId; // Pet'in tip ID'si
    private String typeName; // Pet tipinin adı
    private String breed;
    private String age;
    private String gender; // 'M' veya 'F' olarak kalır
    //private Long advertisementId;
    private List<String> petImages; // Base64 kodlanmış resimlerin listesi
}
