package com.valueup.backend.comment.controller;

import com.valueup.backend.comment.dto.request.CommentRequest;
import com.valueup.backend.comment.dto.request.CommentUpdateRequest;
import com.valueup.backend.comment.dto.response.CommentResponse;
import com.valueup.backend.comment.service.CommentService;
import com.valueup.backend.user.domain.User;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
  private final CommentService commentService;

  @PostMapping
  public ResponseEntity<CommentResponse> createComment(@RequestBody CommentRequest request,
      HttpSession session) {
    User user = (User) session.getAttribute("user");
    return ResponseEntity.status(HttpStatus.CREATED).body(commentService.createComment(request, user));
  }


  @PatchMapping
  public ResponseEntity<Long> updateComment(@RequestBody CommentUpdateRequest request,
      HttpSession session) {
    User user = (User) session.getAttribute("user");
    Long updateId = commentService.updateComment(request, user);
    return ResponseEntity.ok(updateId);
  }

  @DeleteMapping("/{commentId}")
  public ResponseEntity<Void> deleteComment(@PathVariable Long commentId,
      HttpSession session) {
    User user = (User) session.getAttribute("user");
    commentService.deleteComment(commentId, user);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}
