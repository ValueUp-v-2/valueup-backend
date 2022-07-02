package com.valueup.backend.user.domain;

import com.valueup.backend.common.BaseEntity;
import com.valueup.backend.post.domain.Post;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity(name = "tb_user")
public class User extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String nickname;

  @Column
  private String name;

  @Column
  private String email;

  @OneToMany(mappedBy = "user")
  private final List<Post> postList = new ArrayList<>();

  @Builder
  public User(String nickname, String name, String email) {
    this.nickname = nickname;
    this.name = name;
    this.email = email;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
}
