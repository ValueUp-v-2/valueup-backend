package com.valueup.backend.post.domain;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import com.valueup.backend.user.domain.User;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;

public class Like {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "post_like_id")
  private Long id;


  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "post_id")
  private Post post;

  @Builder
  public Like(User user, Post post) {
    this.user = user;
    this.post = post;
  }

  public static Like createLike(User user, Post post) {
    return Like.builder()
        .user(user)
        .post(post)
        .build();
  }
}
