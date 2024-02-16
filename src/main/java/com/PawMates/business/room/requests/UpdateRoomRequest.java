package com.PawMates.business.room.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoomRequest {
    @NotNull(message = "Room ID cannot be null")
    private Long id;

    @NotBlank(message = "Topic cannot be blank")
    private String topic;

    @NotBlank(message = "Description cannot be blank")
    private String description;
}
