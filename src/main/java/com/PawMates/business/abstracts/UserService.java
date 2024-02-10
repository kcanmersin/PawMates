package com.PawMates.business.abstracts;

import com.PawMates.business.user.requests.CreateUserRequest;
import com.PawMates.business.user.requests.UpdateUserRequest;
import com.PawMates.business.user.responses.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAll();
    UserResponse getById(Long id);
    void add(CreateUserRequest createUserRequest);
    void update(UpdateUserRequest updateUserRequest);
    void delete(Long id);
}
