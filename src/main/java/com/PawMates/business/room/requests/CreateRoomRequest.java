package com.PawMates.business.room.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoomRequest {
    @NotBlank(message = "Topic cannot be blank")
    private String topic;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    private Long hostId; // Odanın sahibi olan kullanıcının ID'si
}
