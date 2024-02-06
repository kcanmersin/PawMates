package com.PawMates.business.advertisement.responses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class JobAdvertisementResponse extends AdvertisementResponse {
    private String position;
    private String salary;
    private String workingHours;

    // Additional fields and constructors
}
