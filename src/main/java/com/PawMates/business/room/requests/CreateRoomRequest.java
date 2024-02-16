package com.PawMates.business.room.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateRoomRequest {
    @NotBlank(message = "Description cannot be blank")
    private String description;
    @NotBlank(message = "Topic cannot be blank")
    private String topic;



    private Long userId; // Odanın sahibi olan kullanıcının ID'si
}
