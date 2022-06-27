package com.valueup.backend.post.dto.response;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnnouncementResponse {
  private String name;//게시판 이름

  //작성자

  private String content;//게시판 내용

  private String recruitment; //모집 인원

  private LocalDateTime starDate;//시작 기간

  private LocalDateTime endDate;//종료 기간

  private int period; //활동 기간

  private String url; //게시판 홈페이지


}
