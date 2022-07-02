package com.valueup.backend.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
  NORMAL("ROLE_NORMAL"),
  ENTERPRISE("ROLE_ENTERPRISE");

  private final String key;
}
