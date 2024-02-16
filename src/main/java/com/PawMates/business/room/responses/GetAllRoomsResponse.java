package com.PawMates.business.room.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllRoomsResponse {
    private Long id;
    private String topic;
    private String description;
    private Long hostId; // Odanın sahibi olan kullanıcının ID'si
    private String hostUsername; // Odanın sahibi olan kullanıcının kullanıcı adı
}
