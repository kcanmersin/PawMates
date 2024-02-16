package com.PawMates.webApi.controllers;

import com.PawMates.business.abstracts.CommentService;

import com.PawMates.business.comments.requests.CreateCommentRequest;

import com.PawMates.business.comments.requests.UpdateCommentRequest;
import com.PawMates.business.comments.responses.GetAllCommentsResponse;
import com.PawMates.business.comments.responses.GetByIdCommentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping()
    public List<GetAllCommentsResponse> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public GetByIdCommentResponse getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addComment(@RequestBody @Valid CreateCommentRequest createCommentRequest) {
        commentService.addComment(createCommentRequest);
    }
    //burada commentId yi linkten alma zaten commentlerde parent id var
    @PostMapping("/{commentId}/reply")
    @ResponseStatus(HttpStatus.CREATED)
    public void replyToComment(@PathVariable Long commentId, @RequestBody @Valid CreateCommentRequest replyCommentRequest) {
        commentService.replyToComment(commentId, replyCommentRequest);
    }

    @PutMapping()
    public void updateComment(@RequestBody @Valid UpdateCommentRequest updateCommentRequest) {
        commentService.updateComment(updateCommentRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
