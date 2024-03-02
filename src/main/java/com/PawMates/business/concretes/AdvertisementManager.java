package com.PawMates.business.concretes;

import com.PawMates.business.abstracts.AdvertisementService;
import com.PawMates.business.advertisement.requests.CreateAdoptionAdvertisementRequest;
import com.PawMates.business.advertisement.requests.CreateAdvertisementRequest;
import com.PawMates.core.utilities.mappers.ModelMapperService;
import com.PawMates.dataAccess.abstracts.AdvertisementRepository;
import com.PawMates.entities.concretes.AdoptionAdvertisement;
import com.PawMates.entities.concretes.Advertisement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdvertisementManager implements AdvertisementService {

    private final ModelMapperService modelMapperService;
    private final AdvertisementRepository advertisementRepository;
        @Override
        public void createAdvertisement(CreateAdvertisementRequest createAdvertisementRequest) {
            Advertisement advertisement = modelMapperService.forRequest().map(createAdvertisementRequest, Advertisement.class);
            advertisementRepository.save(advertisement);
        }


    @Override
        public void updateAdvertisement(CreateAdvertisementRequest createAdvertisementRequest) {
            // TODO Auto-generated method stub

        }

        @Override
        public void deleteAdvertisement(Long id) {
            // TODO Auto-generated method stub

        }

        @Override
        public void getAdvertisement(Long id) {
            // TODO Auto-generated method stub

        }

        @Override
        public void getAllAdvertisements() {
            // TODO Auto-generated method stub

        }
}
