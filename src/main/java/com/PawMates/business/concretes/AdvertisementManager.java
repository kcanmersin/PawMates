package com.PawMates.business.concretes;

import com.PawMates.business.abstracts.AdvertisementService;
import com.PawMates.business.abstracts.GenericAdvertisementService;
import com.PawMates.business.advertisement.requests.CreateAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateAdvertisementRequest;
import com.PawMates.business.advertisement.responses.AdvertisementResponse;
import com.PawMates.core.utilities.mappers.ModelMapperService;
import com.PawMates.dataAccess.abstracts.AdvertisementRepository;
import com.PawMates.entities.concretes.Advertisement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdvertisementManager implements GenericAdvertisementService<AdvertisementResponse, Long> {
    private final AdvertisementRepository advertisementRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<AdvertisementResponse> getAll() {
        List<Advertisement> advertisements = advertisementRepository.findAll();
        return advertisements.stream()
                .map(advertisement -> modelMapperService.forResponse().map(advertisement, AdvertisementResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public AdvertisementResponse getById(Long id) {
        Advertisement advertisement = advertisementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Advertisement not found!"));
        return modelMapperService.forResponse().map(advertisement, AdvertisementResponse.class);
    }

    @Override
    public void add(CreateAdvertisementRequest createAdvertisementRequest) {
        Advertisement advertisement = modelMapperService.forRequest().map(createAdvertisementRequest, Advertisement.class);
        advertisementRepository.save(advertisement);
    }

    @Override
    public void update(UpdateAdvertisementRequest updateAdvertisementRequest) {
        Advertisement advertisement = modelMapperService.forRequest().map(updateAdvertisementRequest, Advertisement.class);
        advertisementRepository.save(advertisement);
    }

    @Override
    public void delete(Long id) {
        advertisementRepository.deleteById(id);
    }
}
