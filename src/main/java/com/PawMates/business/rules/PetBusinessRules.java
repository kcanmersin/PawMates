package com.PawMates.business.rules;

import com.PawMates.core.utilities.exceptions.BusinessException;
import com.PawMates.dataAccess.abstracts.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PetBusinessRules {
    private final PetRepository petRepository;

    public void checkIfPetNameExists(String name) {
        if(petRepository.existsByName(name)) {
            throw new BusinessException("Pet name already exists");
        }
    }
}