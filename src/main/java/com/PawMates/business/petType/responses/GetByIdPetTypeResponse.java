package com.PawMates.business.petType.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdPetTypeResponse {
    private Long id;
    private String name;
}
