package com.valueup.backend.comment.service;

import com.valueup.backend.comment.domain.Comment;
import com.valueup.backend.comment.dto.request.CommentRequest;
import com.valueup.backend.comment.dto.request.CommentUpdateRequest;
import com.valueup.backend.comment.dto.response.CommentResponse;
import com.valueup.backend.comment.repository.CommentRepository;
import com.valueup.backend.post.domain.Community;
import com.valueup.backend.post.repository.CommunityRepository;
import com.valueup.backend.user.domain.User;
import com.valueup.backend.user.repository.UserRepository;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CommentServiceImpl implements CommentService {

  private final UserRepository userRepository;
  private final CommunityRepository communityRepository;
  private final CommentRepository commentRepository;

  @Transactional
  @Override
  public CommentResponse createComment(CommentRequest commentRequest, User user) {
    User writer = userRepository.findById(user.getId()).orElse(null);
    Community community = communityRepository.findById(commentRequest.getPostId()).orElse(null);

    Long parentId = commentRequest.getParentId();

    if (Objects.isNull(parentId)) {
      Comment comment = commentRepository.save(Comment.builder()
          .user(writer)
          .community(community)
          .content(commentRequest.getContent())
          .build());

      return new CommentResponse(comment.getId(), comment.getUser().getNickname());
    }

    Comment parent = commentRepository.findById(parentId).orElse(null);
    Comment comment = commentRepository
        .save(Comment.createComment(parent, writer, community, commentRequest.getContent()));

    return new CommentResponse(comment.getId(), comment.getUser().getNickname());
  }

  @Transactional
  @Override
  public Long updateComment(CommentUpdateRequest request, User user) {
    User writer = userRepository.findById(user.getId()).orElse(null);
    Comment comment = commentRepository.findByIdAndUser(request.getCommentId(), writer).orElse(null);
    comment.updateContent(request.getContent());
    return comment.getId();
  }

  @Transactional
  @Override
  public void deleteComment(Long commentId, User user) {
    User writer = userRepository.findById(user.getId()).orElse(null);
    Comment comment = commentRepository.findByIdAndUser(commentId, writer).orElse(null);
    commentRepository.delete(comment);
  }
}
