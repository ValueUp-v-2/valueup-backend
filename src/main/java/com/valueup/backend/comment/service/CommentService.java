package com.valueup.backend.comment.service;

import com.valueup.backend.comment.dto.request.CommentRequest;
import com.valueup.backend.comment.dto.request.CommentUpdateRequest;
import com.valueup.backend.comment.dto.response.CommentResponse;
import com.valueup.backend.user.domain.User;

public interface CommentService {
  CommentResponse createComment(CommentRequest commentRequest, User user);

  Long updateComment(CommentUpdateRequest request, User user);

  void deleteComment(Long commentId, User user);




}
