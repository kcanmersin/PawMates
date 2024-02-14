package com.PawMates.business.abstracts;

import com.PawMates.business.pet.responses.CommentResponse;
import com.PawMates.entities.concretes.Comment;

public interface CommentService {
    Comment addComment(Comment comment);
    void likeComment(Long commentId, Long userId);
    void dislikeComment(Long commentId, Long userId);
    
    // Diğer metodlar...
}
