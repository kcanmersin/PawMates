package com.PawMates.business.advertisement.requests;

import com.PawMates.business.address.requests.CreateAddressRequest;
import com.PawMates.business.pet.requests.CreatePetRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAdvertisementRequest {
    private String title;
    private String content;
    private String phoneNumber;
    private String email;
    private Long addressId; // İlgili adres ID'si
    private List<CreatePetRequest> pets; // Reklam oluştururken evcil hayvanları dahil et
    private List<MultipartFile> images; // Reklam oluştururken resimleri dahil et
}
