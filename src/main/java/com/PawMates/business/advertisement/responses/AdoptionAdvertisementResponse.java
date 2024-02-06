package com.PawMates.business.advertisement.responses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AdoptionAdvertisementResponse extends AdvertisementResponse {
    private String petCondition;
    private String requirementsForAdoption;

    // Additional fields and constructors
}
