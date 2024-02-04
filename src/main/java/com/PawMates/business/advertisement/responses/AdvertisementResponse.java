package com.PawMates.business.advertisement.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementResponse {
    private Long id;
    private String title;
    private String content;
    private String phoneNumber;
    private String email;
    private Long addressId; // İlanın ilişkilendirildiği adresin ID'si

}
