package com.PawMates.business.concretes;

import com.PawMates.business.abstracts.AdoptionAdvertisementService;
import com.PawMates.business.advertisement.requests.CreateAdoptionAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateAdoptionAdvertisementRequest;
import com.PawMates.business.advertisement.responses.AdoptionAdvertisementResponse;
import com.PawMates.core.utilities.mappers.ModelMapperService;
import com.PawMates.dataAccess.abstracts.AdoptionAdvertisementRepository;
import com.PawMates.entities.concretes.AdoptionAdvertisement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdoptionAdvertisementManager implements AdoptionAdvertisementService {
    private final AdoptionAdvertisementRepository adoptionAdvertisementRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<AdoptionAdvertisementResponse> getAll() {
        List<AdoptionAdvertisement> advertisements = adoptionAdvertisementRepository.findAll();
        return advertisements.stream()
                .map(advertisement -> modelMapperService.forResponse().map(advertisement, AdoptionAdvertisementResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public AdoptionAdvertisementResponse getById(Long id) {
        AdoptionAdvertisement advertisement = adoptionAdvertisementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adoption advertisement not found!"));
        return modelMapperService.forResponse().map(advertisement, AdoptionAdvertisementResponse.class);
    }

    @Override
    public void add(CreateAdoptionAdvertisementRequest request) {
        AdoptionAdvertisement advertisement = modelMapperService.forRequest().map(request, AdoptionAdvertisement.class);
        adoptionAdvertisementRepository.save(advertisement);
    }

    @Override
    public void update(UpdateAdoptionAdvertisementRequest request) {
        AdoptionAdvertisement advertisement = modelMapperService.forRequest().map(request, AdoptionAdvertisement.class);
        adoptionAdvertisementRepository.save(advertisement);
    }

    @Override
    public void delete(Long id) {
        adoptionAdvertisementRepository.deleteById(id);
    }
}
