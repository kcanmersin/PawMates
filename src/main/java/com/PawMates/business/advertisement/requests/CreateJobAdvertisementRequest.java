package com.PawMates.business.advertisement.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CreateJobAdvertisementRequest extends CreateAdvertisementRequest {
    private String position;
    private String salary;
    private String workingHours;


}
