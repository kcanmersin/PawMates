package com.PawMates.business.rules;

import com.PawMates.core.utilities.exceptions.BusinessException;
import com.PawMates.dataAccess.abstracts.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserBusinessRules {
    private final UserRepository userRepository;

    public void checkIfUsernameExists(String username) {
        boolean exists = userRepository.existsByUsername(username);
        if(exists) {
            throw new BusinessException("Username already exists");
        }
    }

    public void checkIfEmailExists(String email) {
        boolean exists = userRepository.existsByEmail(email);
        if(exists) {
            throw new BusinessException("Email already exists");
        }
    }
}
