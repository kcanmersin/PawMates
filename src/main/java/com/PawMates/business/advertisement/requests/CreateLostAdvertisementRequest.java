package com.PawMates.business.advertisement.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CreateLostAdvertisementRequest extends CreateAdvertisementRequest {
    private String lastSeenDate;
    private String lastSeenLocation;


}
