package com.PawMates.business.comments.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentRequest {
    @NotBlank(message = "Content cannot be blank")
    private String content;

    private Long userId; // Yorumu yapan kullanıcının ID'si

    private Long parentId; // Üst yorumun ID'si, eğer varsa
}
