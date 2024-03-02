package com.PawMates.business.concretes;

import com.PawMates.business.abstracts.LostAdvertisementService;
import com.PawMates.business.advertisement.requests.CreateLostAdvertisementRequest;
import com.PawMates.business.advertisement.requests.UpdateLostAdvertisementRequest;
import com.PawMates.business.advertisement.responses.LostAdvertisementResponse;
import com.PawMates.business.pet.requests.CreatePetRequest;
import com.PawMates.core.utilities.mappers.ModelMapperService;
import com.PawMates.dataAccess.abstracts.LostAdvertisementRepository;
import com.PawMates.dataAccess.abstracts.PetRepository;
import com.PawMates.entities.concretes.LostAdvertisement;
import com.PawMates.entities.concretes.Pet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LostAdvertisementManager implements LostAdvertisementService {
    private final LostAdvertisementRepository lostAdvertisementRepository;
    private final ModelMapperService modelMapperService;
    private final PetRepository petRepository;
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
        // Map the request to a LostAdvertisement entity
        LostAdvertisement advertisement = modelMapperService.forRequest().map(request, LostAdvertisement.class);

        // Initialize the pets list for the advertisement to ensure it's not null
        advertisement.setPets(new ArrayList<>());

        // Check if there are pet requests to process
        if (request.getPets() != null && !request.getPets().isEmpty()) {
            for (CreatePetRequest petRequest : request.getPets()) {
                // Map each CreatePetRequest to a Pet entity
                Pet pet = modelMapperService.forRequest().map(petRequest, Pet.class);
                pet.setAdvertisement(advertisement); // Associate the pet with the advertisement
                advertisement.getPets().add(pet); // Add the pet to the advertisement's list of pets
            }
        }

        // Now that both sides of the relationship are properly established, save the advertisement
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
