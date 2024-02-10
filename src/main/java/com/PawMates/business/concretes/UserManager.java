package com.PawMates.business.concretes;

import com.PawMates.business.abstracts.UserService;
import com.PawMates.business.rules.UserBusinessRules;
import com.PawMates.business.user.requests.CreateUserRequest;
import com.PawMates.business.user.requests.UpdateUserRequest;
import com.PawMates.business.user.responses.UserResponse;
import com.PawMates.core.utilities.exceptions.BusinessException;
import com.PawMates.core.utilities.mappers.ModelMapperService;
import com.PawMates.dataAccess.abstracts.UserRepository;
import com.PawMates.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;
    private final UserBusinessRules userBusinessRules; // Added UserBusinessRules dependency
    private final PasswordEncoder passwordEncoder;
    @Override
    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapperService.forResponse().map(user, UserResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new BusinessException("User not found!"));
        return modelMapperService.forResponse().map(user, UserResponse.class);
    }

    @Override
    public void add(CreateUserRequest createUserRequest) {
        userBusinessRules.checkIfUsernameExists(createUserRequest.getUsername());
        userBusinessRules.checkIfEmailExists(createUserRequest.getEmail());

        // Hash the password
        String hashedPassword = passwordEncoder.encode(createUserRequest.getPassword());

        User user = modelMapperService.forRequest().map(createUserRequest, User.class);
        user.setPassword(hashedPassword); // Set the hashed password
        userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        User existingUser = userRepository.findById(updateUserRequest.getId())
                .orElseThrow(() -> new BusinessException("User not found!"));

        // Check username and email as before...

        // Optionally, hash the new password if it's different from the old one
        if (!updateUserRequest.getPassword().isEmpty() && !passwordEncoder.matches(updateUserRequest.getPassword(), existingUser.getPassword())) {
            String hashedPassword = passwordEncoder.encode(updateUserRequest.getPassword());
            existingUser.setPassword(hashedPassword); // Update with the new hashed password
        }

        User user = modelMapperService.forRequest().map(updateUserRequest, User.class);
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
