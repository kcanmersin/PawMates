package com.PawMates.business.concretes;

import com.PawMates.business.abstracts.CommentService;
import com.PawMates.business.comments.requests.UpdateCommentRequest;
import com.PawMates.business.comments.responses.GetByIdCommentResponse;
import com.PawMates.business.comments.requests.CreateCommentRequest;
import com.PawMates.business.comments.responses.GetAllCommentsResponse;
import com.PawMates.core.utilities.mappers.ModelMapperService;
import com.PawMates.dataAccess.abstracts.CommentRepository;
import com.PawMates.entities.concretes.Comment;
import com.PawMates.entities.concretes.Pet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentManager implements CommentService {

    private final CommentRepository commentRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public Comment addComment(CreateCommentRequest request) {
        Comment comment = modelMapperService.forRequest().map(request, Comment.class);
        // Ayarlamalar yap ve kaydet
        return commentRepository.save(comment);
    }

    @Override
    public void updateComment(UpdateCommentRequest request) {
        Comment comment = modelMapperService.forRequest().map(request, Comment.class);
        commentRepository.save(comment);
    }


    @Override
    public List<GetAllCommentsResponse> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(comment -> modelMapperService.forResponse().map(comment, GetAllCommentsResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetByIdCommentResponse getCommentById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + id));
        return modelMapperService.forResponse().map(comment, GetByIdCommentResponse.class);
    }

    @Override
    public Comment replyToComment(Long commentId, CreateCommentRequest request) {
        Comment parentComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Parent comment not found with id: " + commentId));
        Comment replyComment = modelMapperService.forRequest().map(request, Comment.class);
        replyComment.setParent(parentComment);
        // Kullanıcı ve diğer ilişkiler ayarlanabilir
        return commentRepository.save(replyComment);
    }

    // delete metodunun implementasyonu
    @Override
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + id));
        commentRepository.delete(comment);
    }
}
