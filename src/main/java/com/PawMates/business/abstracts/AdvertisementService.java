package com.PawMates.business.abstracts;

import com.PawMates.business.advertisement.requests.CreateAdvertisementRequest;

public interface AdvertisementService {

    //crud
    void createAdvertisement(CreateAdvertisementRequest createAdvertisementRequest);
    void updateAdvertisement(CreateAdvertisementRequest createAdvertisementRequest);
    void deleteAdvertisement(Long id);
    void getAdvertisement(Long id);
    void getAllAdvertisements();
}
