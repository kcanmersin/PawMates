package com.PawMates.business.room.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdRoomResponse {
    private Long id;
    private String topic;
    private String description;
    private Long userId;
    private String username; // Odanın sahibi olan kullanıcının kullanıcı adı
}
