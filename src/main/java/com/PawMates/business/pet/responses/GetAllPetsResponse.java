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
    private Long advertisementId;

    // Pet'in resimlerini içeren Base64 kodlanmış stringlerin listesi
    private List<String> petImages; // Pet'in tüm resimlerini döndürmek için eklendi
}
