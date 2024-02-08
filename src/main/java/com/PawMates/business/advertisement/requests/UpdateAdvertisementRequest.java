package com.PawMates.business.advertisement.requests;

import com.PawMates.business.pet.requests.CreatePetRequest;
import com.PawMates.business.pet.requests.UpdatePetRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAdvertisementRequest {
    private Long id; // Güncellenecek ilanın ID'si

    private String title;
    private String content;
    private String phoneNumber;
    private String email;
    private Long addressId; // Related address ID
    private List<UpdatePetRequest> pets; // Include pets in advertisement creation
    // private CreateAddressRequest address; // Include address in advertisement creation
}
