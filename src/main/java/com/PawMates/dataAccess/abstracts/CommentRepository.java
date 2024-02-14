package com.PawMates.dataAccess.abstracts;

import com.PawMates.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Buraya özel sorgularınızı ekleyebilirsiniz.
}
