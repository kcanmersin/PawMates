package com.PawMates.business.advertisement.responses;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class JobAdvertisementResponse extends AdvertisementResponse {

    private String position;
    private String salary;
    private String workingHours;

    // Additional fields and constructors
}
