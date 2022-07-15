package com.valueup.backend.post.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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


  @Builder
  public Community(Long id, String name, String content, int views,
      CommunityCategory communityCategory, int likes) {
    this.id = id;
    this.name = name;
    this.content = content;
    this.views = views;
    this.communityCategory = communityCategory;
    this.likes = likes;
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
