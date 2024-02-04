package com.PawMates.business.advertisement.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CreateAdoptionAdvertisementRequest extends CreateAdvertisementRequest {
    private String petCondition;
    private String requirementsForAdoption;


}
