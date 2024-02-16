package com.PawMates.business.comments.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCommentResponse {
    private Long id;
    private String content;
    private Long userId;
    private String userName; // Yorumu yapan kullanıcının adı
    private Long parentId; // Eğer alt yorum ise, üst yorumun ID'si
}
