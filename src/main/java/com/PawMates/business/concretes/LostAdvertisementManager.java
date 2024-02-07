package com.PawMates.business.concretes;

import com.PawMates.business.abstracts.LostAdvertisementService;
import com.PawMates.business.advertisement.requests.CreateLostAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateLostAdvertisementRequest;
import com.PawMates.business.advertisement.responses.LostAdvertisementResponse;
import com.PawMates.core.utilities.mappers.ModelMapperService;
import com.PawMates.dataAccess.abstracts.LostAdvertisementRepository;
import com.PawMates.entities.concretes.LostAdvertisement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LostAdvertisementManager implements LostAdvertisementService {
    private final LostAdvertisementRepository lostAdvertisementRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<LostAdvertisementResponse> getAll() {
        List<LostAdvertisement> advertisements = lostAdvertisementRepository.findAll();
        return advertisements.stream()
                .map(advertisement -> modelMapperService.forResponse().map(advertisement, LostAdvertisementResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public LostAdvertisementResponse getById(Long id) {
        LostAdvertisement advertisement = lostAdvertisementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lost advertisement not found!"));
        return modelMapperService.forResponse().map(advertisement, LostAdvertisementResponse.class);
    }

    @Override
    public void add(CreateLostAdvertisementRequest request) {
        LostAdvertisement advertisement = modelMapperService.forRequest().map(request, LostAdvertisement.class);
        lostAdvertisementRepository.save(advertisement);
    }

    @Override
    public void update(UpdateLostAdvertisementRequest request) {
        LostAdvertisement advertisement = modelMapperService.forRequest().map(request, LostAdvertisement.class);
        lostAdvertisementRepository.save(advertisement);
    }

    @Override
    public void delete(Long id) {
        lostAdvertisementRepository.deleteById(id);
    }
}
