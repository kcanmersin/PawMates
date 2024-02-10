package com.PawMates.webApi.controllers;

import com.PawMates.business.abstracts.UserService;
import com.PawMates.business.user.requests.CreateUserRequest;
import com.PawMates.business.user.requests.UpdateUserRequest;
import com.PawMates.business.user.responses.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateUserRequest createUserRequest) {
        userService.add(createUserRequest);
    }

    @PutMapping()
    public void update(@RequestBody @Valid UpdateUserRequest updateUserRequest) {
        userService.update(updateUserRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
