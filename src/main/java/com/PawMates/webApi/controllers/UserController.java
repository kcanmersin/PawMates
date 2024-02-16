package com.PawMates.webApi.controllers;

import com.PawMates.business.abstracts.UserService;
import com.PawMates.business.users.requests.CreateUserRequest;
import com.PawMates.business.users.requests.UpdateUserRequest;
import com.PawMates.business.users.responses.GetUserByIdResponse;
import com.PawMates.business.users.responses.GetUserByUsernameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<GetUserByIdResponse> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public GetUserByIdResponse getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/username/{username}")
    public GetUserByUsernameResponse getByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GetUserByIdResponse add(@RequestBody CreateUserRequest request) {
        return userService.addUser(request);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody UpdateUserRequest request) {

        userService.updateUser(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
