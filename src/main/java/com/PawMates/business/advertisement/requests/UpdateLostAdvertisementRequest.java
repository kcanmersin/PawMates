package com.PawMates.business.advertisement.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateLostAdvertisementRequest extends UpdateAdvertisementRequest {
    private String lastSeenDate;
    private String lastSeenLocation;

}
