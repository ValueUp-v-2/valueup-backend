package com.valueup.backend.post.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("A")// 구분자 상의해보기
@Getter
public class Community extends Post {

  @Column(name = "community_likes")
  private int likes;//좋아요 수

  //카테고리 따로 테이블 생성??? enum처리????

  @Builder
  public Community(Long id, String name, String content, int views, int likes) {
    this.id = id;
    this.name = name;
    this.content = content;
    this.views = views;
    this.likes = likes;
  }

  public void updateName(String name) {
    this.name = name;
  }

  public void updateContent(String content) {
    this.content = content;
  }
}
