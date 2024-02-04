package com.PawMates.business.advertisement.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateAdoptionAdvertisementRequest extends UpdateAdvertisementRequest {
    private String petCondition;
    private String requirementsForAdoption;

    // Constructors, Getters, and Setters
}
