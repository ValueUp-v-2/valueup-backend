package com.valueup.backend.post.dto.response;

import com.valueup.backend.post.domain.Community;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommunityResponse {

  private String name;//게시판 이름

  private String content;//게시판 내용

  private String nickname; //유저 닉네임

  private int likes;

  public CommunityResponse(Community community) {
    this.name = community.getName();
    this.content = community.getContent();
    this.nickname = community.getUser().getNickname();
  }
}
