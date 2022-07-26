package com.valueup.backend.comment.domain;

import static javax.persistence.FetchType.LAZY;

import com.valueup.backend.common.BaseEntity;
import com.valueup.backend.post.domain.Community;
import com.valueup.backend.post.domain.Post;
import com.valueup.backend.user.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Getter
public class Comment extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "comment_id")
  private Long id; //댓글 번호

  @Column(name = "comment_content")
  @Lob
  private String content; //댓글 내용


  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "parent_id")
  private Comment parent;

  @OneToMany(mappedBy = "parent", orphanRemoval = true)
  private List<Comment> children = new ArrayList<>();

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "user_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private User user;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "post_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Community community;

  @Builder
  public Comment(String content, Comment parent, User user, Community community) {
    this.content = content;
    this.parent = parent;
    this.user = user;
    this.community = community;
  }

  public static Comment createComment(Comment parent, User user, Community community, String content) {
    return Comment.builder()
        .user(user)
        .community(community)
        .parent(parent)
        .content(content)
        .build();
  }


  public void updateContent(String content) {
    this.content = content;
  }


}
