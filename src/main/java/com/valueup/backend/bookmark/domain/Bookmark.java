package com.valueup.backend.bookmark.domain;

import static javax.persistence.FetchType.LAZY;

import com.valueup.backend.post.domain.Post;
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
public class Bookmark {

  @Id
  @GeneratedValue
  @Column(name = "bookmark_id")
  private Long id; //북마크 번호

//  @Column(name = "bookmark_isCommunity")
//  private boolean isCommunity;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "post_id")
  private Post post;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @Builder
  public Bookmark(Post post, User user) {
    this.post = post;
    this.user = user;
  }

  public static Bookmark createBookmark(Post post, User user){
    return Bookmark.builder()
        .user(user)
        .post(post)
        .build();
  }
}
