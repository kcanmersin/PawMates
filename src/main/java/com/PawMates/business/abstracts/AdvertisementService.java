package com.PawMates.business.abstracts;

import com.PawMates.business.advertisement.requests.CreateAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateAdvertisementRequest;
import com.PawMates.business.advertisement.responses.AdvertisementResponse;

import java.util.List;

public interface AdvertisementService {
    List<AdvertisementResponse> getAll();
    AdvertisementResponse getById(Long id);
    void add(CreateAdvertisementRequest createAdvertisementRequest);
    void update(UpdateAdvertisementRequest updateAdvertisementRequest);
    void delete(Long id);
}
