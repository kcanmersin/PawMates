package com.PawMates.dataAccess.abstracts;

import com.PawMates.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByRoomId(Long roomId);
}
