package com.PawMates.business.room.responses;

import com.PawMates.business.comments.responses.GetAllCommentsResponse;
import com.PawMates.business.comments.responses.GetByIdCommentResponse;
import com.PawMates.entities.concretes.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllRoomsResponse {
    private Long id;
    private String topic;
    private String description;

    private Long userId; // Odanın sahibi olan kullanıcının ID'si
    private String username; // Odanın sahibi olan kullanıcının kullanıcı adı
    private List<GetAllCommentsResponse> comments; // Odanın yorumları
}
