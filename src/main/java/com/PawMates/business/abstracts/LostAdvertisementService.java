package com.PawMates.business.abstracts;

import com.PawMates.business.advertisement.requests.CreateLostAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateLostAdvertisementRequest;
import com.PawMates.business.advertisement.responses.LostAdvertisementResponse;

import java.util.List;

public interface LostAdvertisementService {
    List<LostAdvertisementResponse> getAll();
    LostAdvertisementResponse getById(Long id);
    void add(CreateLostAdvertisementRequest createLostAdvertisementRequest);
    void update(UpdateLostAdvertisementRequest updateLostAdvertisementRequest);
    void delete(Long id);
}
