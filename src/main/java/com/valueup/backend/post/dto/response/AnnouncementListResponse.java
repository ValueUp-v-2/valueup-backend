package com.valueup.backend.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnnouncementListResponse {
  //썸네일?
  
  private String name;//게시판 이름

  //작성자
  
  private int views;//조회수
  
  private int comments;//댓글수
}
