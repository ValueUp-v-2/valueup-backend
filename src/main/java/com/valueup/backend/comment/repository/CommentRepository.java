package com.valueup.backend.comment.repository;


import com.valueup.backend.comment.domain.Comment;

import com.valueup.backend.user.domain.User;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Long> {


  Optional<Comment> findByUser(User user);

  Optional<Comment> findByIdAndUser(Long id, User user);


}
