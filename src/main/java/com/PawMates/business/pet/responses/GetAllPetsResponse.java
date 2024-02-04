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
    private Long typeId; // To include the pet's type ID
    private String typeName; // Changed to display the type name
    private String breed;
    private String age;
    private String gender; // Remains a String, but will be 'M' or 'F'
}
