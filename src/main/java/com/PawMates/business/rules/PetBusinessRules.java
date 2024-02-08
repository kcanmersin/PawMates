package com.PawMates.business.rules;

import com.PawMates.core.utilities.exceptions.BusinessException;
import com.PawMates.dataAccess.abstracts.PetRepository;
import com.PawMates.dataAccess.abstracts.PetTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PetBusinessRules {
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

//    public void checkIfPetNameExists(String name) {
//        if (petRepository.existsByName(name)) {
//            throw new BusinessException("Pet name already exists");
//        }
//    }

    public void checkIfPetTypeExists(Long typeId) {
        if (!petTypeRepository.existsById(typeId)) {
            throw new BusinessException("Pet type does not exist");
        }
    }
}
