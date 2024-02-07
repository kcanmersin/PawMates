package com.PawMates.business.abstracts;

import com.PawMates.business.advertisement.requests.CreateAdoptionAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateAdoptionAdvertisementRequest;
import com.PawMates.business.advertisement.responses.AdoptionAdvertisementResponse;

import java.util.List;

public interface AdoptionAdvertisementService {
    List<AdoptionAdvertisementResponse> getAll();
    AdoptionAdvertisementResponse getById(Long id);
    void add(CreateAdoptionAdvertisementRequest createAdoptionAdvertisementRequest);
    void update(UpdateAdoptionAdvertisementRequest updateAdoptionAdvertisementRequest);
    void delete(Long id);
}
