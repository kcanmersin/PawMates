package com.PawMates.business.advertisement.responses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class LostAdvertisementResponse extends AdvertisementResponse {
    private String lastSeenDate;
    private String lastSeenLocation;

    // Additional fields and constructors
}
