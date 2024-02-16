package com.PawMates.business.comments.requests;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCommentRequest {
    @NotNull(message = "Comment ID cannot be null")
    private Long id;

    @NotBlank(message = "Content cannot be blank")
    private String content;
}
