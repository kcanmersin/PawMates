package com.PawMates.business.concretes;

import com.PawMates.authorization.models.User;
import com.PawMates.authorization.repository.UserRepository;
import com.PawMates.business.abstracts.UserService;
import com.PawMates.business.users.requests.CreateUserRequest;
import com.PawMates.business.users.requests.UpdateUserRequest;
import com.PawMates.business.users.responses.GetUserByIdResponse;
import com.PawMates.business.users.responses.GetUserByUsernameResponse;
import com.PawMates.core.utilities.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public GetUserByIdResponse addUser(CreateUserRequest request) {
        User user = modelMapperService.forRequest().map(request, User.class);
        userRepository.save(user);
        return modelMapperService.forResponse().map(user, GetUserByIdResponse.class);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(UpdateUserRequest request) {
        User user = modelMapperService.forRequest().map(request, User.class);
        userRepository.save(user);
    }

    @Override
    public List<GetUserByIdResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapperService.forResponse().map(user, GetUserByIdResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetUserByIdResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));
        return modelMapperService.forResponse().map(user, GetUserByIdResponse.class);
    }

    @Override
    public GetUserByUsernameResponse getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found!"));
        return modelMapperService.forResponse().map(user, GetUserByUsernameResponse.class);
    }
}
