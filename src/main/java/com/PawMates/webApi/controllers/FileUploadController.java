package com.PawMates.webApi.controllers;

import com.PawMates.business.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/users")
public class FileUploadController {

    private final UserService userService;

    @Autowired
    public FileUploadController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{userId}/upload-profile-picture")
    @Operation(summary = "Uploads a profile picture for a user", description = "Provide a user ID and select a file to upload as the profile picture.", responses = {
            @ApiResponse(responseCode = "200", description = "Profile picture uploaded successfully"),
            @ApiResponse(responseCode = "417", description = "Could not upload the file", content = @Content)
    })
    public ResponseEntity<String> uploadProfilePicture(
            @Parameter(description = "The ID of the user to upload the profile picture for", required = true) @PathVariable Long userId,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The file to upload as profile picture", content = @Content(mediaType = "multipart/form-data", schema = @Schema(type = "string", format = "binary"))) @RequestParam("file") MultipartFile file) {
        try {
            userService.updateProfilePicture(userId, file);
            return ResponseEntity.ok("Profile picture uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Could not upload the file: " + file.getOriginalFilename() + "!");
        }
    }
}
