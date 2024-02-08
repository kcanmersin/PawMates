package com.PawMates.business.advertisement.requests;

import com.PawMates.business.address.requests.CreateAddressRequest;
import com.PawMates.business.pet.requests.CreatePetRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdvertisementRequest {
    private String title;
    private String content;
    private String phoneNumber;
    private String email;
    private Long addressId; // Related address ID
   // private CreateAddressRequest address; // Include address in advertisement creation
    private List<CreatePetRequest> pets; // Include pets in advertisement creation
    //private List<CreatePetRequest> pets; // Include pets in advertisement creation
}
