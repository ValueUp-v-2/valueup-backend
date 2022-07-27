package com.valueup.backend.post.domain;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import com.valueup.backend.user.domain.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Getter
public class CommunityLike {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "post_like_id")
  private Long id;


  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "post_id")
  private Community community;

  @Builder
  public CommunityLike(User user, Community community) {
    this.user = user;
    this.community = community;
  }

  public static CommunityLike createLike(User user, Community community) {
    return CommunityLike.builder()
        .user(user)
        .community(community)
        .build();
  }
}
