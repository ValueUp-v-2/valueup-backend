package com.valueup.backend.post.dto.request;

import com.valueup.backend.post.domain.Community;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommunityRequest {

  @NotNull
  @NotBlank(message = "제목을 입력해주세요.")
  private String name;//게시판 이름

  @NotNull
  @NotBlank(message = "내용을 입력해주세요.")
  private String content;//게시판 내용


  public Community DtoToCommunity(CommunityRequest req) {
    Community community = Community.builder()
        .name(name)
        .content(content)
        .build();
    return new Community();

  }
}
