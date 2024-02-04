package com.PawMates.business.concretes;

import com.PawMates.business.abstracts.PetService;
import com.PawMates.business.pet.requests.CreatePetRequest;
import com.PawMates.business.pet.requests.UpdatePetRequest;
import com.PawMates.business.pet.responses.GetAllPetsResponse;
import com.PawMates.business.pet.responses.GetByIdPetResponse;
import com.PawMates.business.rules.PetBusinessRules;
import com.PawMates.core.utilities.mappers.ModelMapperService;
import com.PawMates.dataAccess.abstracts.PetRepository;
import com.PawMates.entities.concretes.Pet;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PetManager implements PetService {
    private  PetRepository petRepository;
    private PetBusinessRules petBusinessRules;
    private  ModelMapperService modelMapperService;

    @Override
    public List<GetAllPetsResponse> getAll() {
        List<Pet> pets = petRepository.findAll();
        return pets.stream()
                .map(pet -> modelMapperService.forResponse()
                        .map(pet, GetAllPetsResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetByIdPetResponse getById(Long id) {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found!")); // RuntimeException yerine daha spesifik bir hata yönetimi yapısı kullanılabilir.
        return modelMapperService.forResponse().map(pet, GetByIdPetResponse.class);
    }

    @Override
    public void add(CreatePetRequest createPetRequest) {
        // Check if the pet name already exists
        //petBusinessRules.checkIfPetNameExists(createPetRequest.getName());

        // Check if the referenced pet type exists
        petBusinessRules.checkIfPetTypeExists(createPetRequest.getTypeId());

        Pet pet = modelMapperService.forRequest().map(createPetRequest, Pet.class);
        petRepository.save(pet);
    }

    @Override
    public void update(UpdatePetRequest updatePetRequest) {
        Pet pet = modelMapperService.forRequest().map(updatePetRequest, Pet.class);
        petRepository.save(pet); // Mevcut pet'in üzerine yazılması gerekiyor, bu yüzden güncellenmeden önce varlığın kontrolü yapılabilir.
    }

    @Override
    public void delete(Long id) {
        petRepository.deleteById(id);
    }
}
