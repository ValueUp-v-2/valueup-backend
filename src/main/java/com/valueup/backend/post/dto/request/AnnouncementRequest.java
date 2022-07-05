package com.valueup.backend.post.dto.request;

import com.valueup.backend.post.domain.Announcement;
import com.valueup.backend.user.domain.User;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnnouncementRequest {

  @NotNull
  @NotBlank(message = "제목을 입력해주세요.")
  private String name;//게시판 이름

  @NotNull
  @NotBlank(message = "내용을 입력해주세요.")
  private String content;//게시판 내용


  @NotNull
  private int recruitment; //모집 인원

  @NotNull
  private LocalDateTime starDate;//시작 기간

  @NotNull
  private LocalDateTime endDate;//종료 기간

  @NotNull
  private int period; //활동 기간

  @NotNull
  private String url; //게시판 홈페이지


  public Announcement DtoToAnnouncement(AnnouncementRequest req, User user) {
    Announcement announcement = Announcement.builder()
        .name(name)
        .content(content)
        .user(user)
        .recruitment(recruitment)
        .starDate(starDate).endDate(endDate)
        .period(period)
        .url(url)
        .build();
    return announcement;
  }


}
