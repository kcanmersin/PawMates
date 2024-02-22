package com.PawMates.webApi.controllers;

import com.PawMates.authorization.models.User;
import com.PawMates.business.abstracts.UserService;
import com.PawMates.business.users.requests.CreateUserRequest;
import com.PawMates.business.users.requests.UpdateUserRequest;
import com.PawMates.business.users.responses.GetUserByIdResponse;
import com.PawMates.business.users.responses.GetUserByUsernameResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.PawMates.business.abstracts.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PutMapping(value = "/{userId}/profile-picture", consumes = "multipart/form-data")
    public ResponseEntity<Void> updateProfilePicture(@PathVariable Long userId,
                                                     @RequestParam("profilePicture") MultipartFile profilePicture) {
        try {
            userService.updateProfilePicture(userId, profilePicture);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping(value = "/{userId}/background-picture", consumes = "multipart/form-data")
    public ResponseEntity<Void> updateBackgroundPicture(@PathVariable Long userId,
                                                       @RequestParam("backgroundPicture") MultipartFile backgroundPicture) {
        try {
            userService.updateBackgroundPicture(userId, backgroundPicture);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
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
