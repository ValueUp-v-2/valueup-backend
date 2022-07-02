package com.valueup.backend.post.dto.response;

import com.valueup.backend.post.domain.Announcement;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnnouncementResponse {

  private Long id;//게시판 아이디

  private String name;//게시판 이름

  //작성자

  private String content;//게시판 내용

  private String recruitment; //모집 인원

  private LocalDateTime starDate;//시작 기간

  private LocalDateTime endDate;//종료 기간

  private int period; //활동 기간

  private String url; //게시판 홈페이지

  private int views;//조회수

  private int comments;//댓글수

  public AnnouncementResponse(Announcement announcement) {
    this.id = announcement.getId();
    this.name = announcement.getName();
    this.starDate = announcement.getStarDate();
    this.endDate = announcement.getEndDate();
    this.period = announcement.getPeriod();
    this.url = announcement.getUrl();
  }

  //썸네일?


}
