package com.PawMates.business.abstracts;

import com.PawMates.business.pet.requests.CreatePetRequest;
import com.PawMates.business.pet.requests.UpdatePetRequest;
import com.PawMates.business.pet.responses.GetAllPetsResponse;
import com.PawMates.business.pet.responses.GetByIdPetResponse;

import java.util.List;

public interface PetService {
    List<GetAllPetsResponse> getAll();
    GetByIdPetResponse getById(Long id);
    void add(CreatePetRequest createPetRequest);
    void update(UpdatePetRequest updatePetRequest);
    void delete(Long id);
}