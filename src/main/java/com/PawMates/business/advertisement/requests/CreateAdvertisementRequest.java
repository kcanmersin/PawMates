package com.PawMates.business.advertisement.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdvertisementRequest {
    private String title;
    private String content;
    private String phoneNumber;
    private String email;
    private Long addressId; // İlanla ilişkilendirilecek adresin ID'si
}
