package com.PawMates.business.advertisement.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateJobAdvertisementRequest extends UpdateAdvertisementRequest {
    private String position;
    private String salary;
    private String workingHours;

    // Constructors, Getters, and Setters
}
