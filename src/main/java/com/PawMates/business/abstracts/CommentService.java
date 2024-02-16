package com.PawMates.business.abstracts;

import com.PawMates.business.comments.requests.CreateCommentRequest;
import com.PawMates.business.comments.requests.UpdateCommentRequest;
import com.PawMates.business.comments.responses.GetAllCommentsResponse;
import com.PawMates.business.comments.responses.GetByIdCommentResponse;
import com.PawMates.entities.concretes.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(CreateCommentRequest request);
    void deleteComment(Long id);
    void updateComment(UpdateCommentRequest request);
    List<GetAllCommentsResponse> getAllComments();
    GetByIdCommentResponse getCommentById(Long id);
    Comment replyToComment(Long commentId, CreateCommentRequest request);
}
