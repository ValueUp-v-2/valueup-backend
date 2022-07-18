package com.valueup.backend.post.domain;

import static javax.persistence.FetchType.LAZY;

import com.valueup.backend.bookmark.domain.Bookmark;
import com.valueup.backend.common.BaseEntity;
import com.valueup.backend.user.domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")// 수정 필요--> 같이 정하기
@Getter
public abstract class Post extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "post_id")
  protected Long id; //게시판 번호

  @Column(name = "post_name")
  protected String name;//게시판 이름

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "user_id") // 작성자 번호
  protected User user;


  @Column(name = "post_content")
  @Lob
  protected String content;//게시판 내용

  @Column(name = "post_views")
  protected int views;//게시판 조회수

  @OneToMany(mappedBy = "post", orphanRemoval = true)
  private List<Bookmark> bookmarks = new ArrayList<>();

}
