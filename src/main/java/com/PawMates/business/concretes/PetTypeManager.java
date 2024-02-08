package com.PawMates.business.concretes;

import com.PawMates.business.abstracts.PetTypeService;
import com.PawMates.business.pet.responses.GetByIdPetResponse;
import com.PawMates.business.petType.requests.CreatePetTypeRequest;
import com.PawMates.business.petType.requests.UpdatePetTypeRequest;
import com.PawMates.business.petType.responses.GetAllPetTypesResponse;
import com.PawMates.business.rules.PetBusinessRules;
import com.PawMates.business.rules.PetTypeBusinessRules;
import com.PawMates.core.utilities.mappers.ModelMapperService;
import com.PawMates.dataAccess.abstracts.PetTypeRepository;
import com.PawMates.entities.concretes.Pet;
import com.PawMates.entities.concretes.PetType;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PetTypeManager implements PetTypeService {
    private PetTypeBusinessRules petTypeBusinessRules;
    private final PetTypeRepository petTypeRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetAllPetTypesResponse> getAll() {
        List<PetType> petTypes = petTypeRepository.findAll();
        return petTypes.stream()
                .map(petType -> modelMapperService.forResponse().map(petType, GetAllPetTypesResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetByIdPetResponse getById(Long id) {
        PetType petType = petTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PetType not found!"));
        return modelMapperService.forResponse().map(petType, GetByIdPetResponse.class);
    }

    @Override
    public void add(CreatePetTypeRequest request) {
        petTypeBusinessRules.checkIfPetTypeNameExists(request.getName());
        PetType petType = modelMapperService.forRequest().map(request, PetType.class);
        petTypeRepository.save(petType);
    }

    @Override
    public void update(UpdatePetTypeRequest updatePetTypeRequest) {
        petTypeBusinessRules.checkIfPetTypeNameExists(updatePetTypeRequest.getName());
        PetType pet = modelMapperService.forRequest().map(updatePetTypeRequest, PetType.class);
        petTypeRepository.save(pet); // Mevcut pet'in üzerine yazılması gerekiyor, bu yüzden güncellenmeden önce varlığın kontrolü yapılabilir.
    }


    @Override
    public void delete(Long id) {
        petTypeRepository.deleteById(id);
    }
}