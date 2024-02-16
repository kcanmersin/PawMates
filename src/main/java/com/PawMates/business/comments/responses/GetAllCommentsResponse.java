package com.PawMates.business.comments.responses;

import com.PawMates.authorization.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCommentsResponse {
    private Long id;
    private String content;
    //private User user; // Yorumu yapan kullanıcı
    private Long userId; // Yorumu yapan kullanıcının ID'si
    private String username; // Yorumu yapan kullanıcının adı
    private Long parentId; // Üst yorumun ID'si, eğer alt yorum ise
}
