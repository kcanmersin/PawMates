package com.PawMates.business.rules;

import com.PawMates.core.utilities.exceptions.BusinessException;
import com.PawMates.dataAccess.abstracts.AddressRepository;
import com.PawMates.dataAccess.abstracts.PetRepository;
import com.PawMates.dataAccess.abstracts.PetTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressBusinessRules {
    // Business rules for address operations
    private AddressRepository addressRepository;

    public void checkIfAddressExists(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new BusinessException("Address does not exist");
        }
    }
}
