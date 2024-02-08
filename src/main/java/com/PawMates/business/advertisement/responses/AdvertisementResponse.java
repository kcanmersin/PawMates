package com.PawMates.business.advertisement.responses;

import com.PawMates.business.address.responses.AddressResponse;
import com.PawMates.business.pet.responses.GetAllPetsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
    private AddressResponse address;
    private List<GetAllPetsResponse> pets;
    private LocalDateTime createdDate;
}
