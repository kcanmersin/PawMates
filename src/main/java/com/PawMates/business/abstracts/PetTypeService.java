package com.PawMates.business.abstracts;

import com.PawMates.business.pet.responses.GetByIdPetResponse;
import com.PawMates.business.petType.requests.CreatePetTypeRequest;
import com.PawMates.business.petType.requests.UpdatePetTypeRequest;
import com.PawMates.business.petType.responses.GetAllPetTypesResponse;

import java.util.List;

public interface PetTypeService {
    List<GetAllPetTypesResponse> getAll();
    GetByIdPetResponse getById(Long id);
    void add(CreatePetTypeRequest request);
    void update(UpdatePetTypeRequest updatePetTypeRequest);
    void delete(Long id);
}