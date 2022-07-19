package com.valueup.backend.post.domain;

import com.valueup.backend.comment.domain.Comment;
import com.valueup.backend.user.domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("C")
@Getter
public class Community extends Post {

  @Enumerated(EnumType.STRING)
  @Column(name = "community_category")
  private CommunityCategory communityCategory; //게시판 카테고리

  @Column(name = "community_likes")
  private int likes;//좋아요 수

  @OneToMany(mappedBy = "community", orphanRemoval = true)
  private List<Comment> comments = new ArrayList<>();


  @Builder
  public Community(Long id, String name, String content, int views,
      CommunityCategory communityCategory, int likes, User user, List<Comment> comments) {
    this.id = id;
    this.name = name;
    this.content = content;
    this.views = views;
    this.communityCategory = communityCategory;
    this.likes = likes;
    this.user = user;
    this.comments = comments;

  }

  public void updateName(String name) {
    this.name = name;
  }

  public void updateContent(String content) {
    this.content = content;
  }

  public void updateCommunityCategory(CommunityCategory communityCategory) {
    this.communityCategory = communityCategory;
  }
}
