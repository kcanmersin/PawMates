package com.PawMates.business.rules;

import com.PawMates.core.utilities.exceptions.BusinessException;
import com.PawMates.dataAccess.abstracts.PetRepository;
import com.PawMates.dataAccess.abstracts.PetTypeRepository;
import com.PawMates.entities.concretes.PetType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PetTypeBusinessRules {
    private final PetTypeRepository petRepository;

    public void checkIfPetNameExists(String name) {
        if(petRepository.existsByName(name)) {
            throw new BusinessException("Pet Type name already exists");
        }
    }
}
