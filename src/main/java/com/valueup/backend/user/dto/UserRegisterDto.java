package com.valueup.backend.user.dto;

import com.valueup.backend.user.domain.Role;
import com.valueup.backend.user.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDto {
  private String nickname;
  private String name;
  private String email;

  public User toEntity() {
    return User.builder()
        .nickname(nickname)
        .name(name)
        .email(email)
        .role(Role.NORMAL)
        .build();
  }
}
