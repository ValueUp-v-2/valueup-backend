package com.valueup.backend.user.domain;

import com.valueup.backend.common.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Role role;

  @Builder
  public User(String nickname, String name, String email, Role role) {
    this.nickname = nickname;
    this.name = name;
    this.email = email;
    this.role = role;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getRoleKey() {
    return this.role.getKey();
  }
}
