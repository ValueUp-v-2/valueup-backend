package com.valueup.backend.post.domain;

import com.valueup.backend.hashtag.domain.HashtagPost;
import com.valueup.backend.user.domain.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("A")
@Getter

public class Announcement extends Post {

  @Enumerated(EnumType.STRING)
  @Column(name = "announcement_kind")
  private AnnouncementKind kind; //게시판 종류

  @Column(name = "announcement_recruitment")
  private int recruitment; //모집 인원

  @Column(name = "announcement_start_date")
  private LocalDateTime starDate;//시작 기간

  @Column(name = "announcement_end_date")
  private LocalDateTime endDate;//종료 기간

  @Column(name = "announcement_period")
  private int period; //활동 기간

  @Column(name = "announcement_url")
  private String url; //게시판 홈페이지

  @OneToMany(mappedBy = "announcement", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  private List<HashtagPost> hashtagPosts = new ArrayList<>();

  @Builder
  public Announcement(Long id, String name, String content, User user, int views, AnnouncementKind kind, int recruitment,
      LocalDateTime starDate, LocalDateTime endDate, int period, String url, List<HashtagPost> hashtagPosts) {
    this.id = id;
    this.name = name;
    this.content = content;
    this.user = user;
    this.views = views;
    this.kind = kind;
    this.recruitment = recruitment;
    this.starDate = starDate;
    this.endDate = endDate;
    this.period = period;
    this.url = url;
    this.hashtagPosts = hashtagPosts;
  }


  //추후 update용 생성자 만들기?
  public void updateName(String name) {
    this.name = name;
  }

  public void updateContent(String content) {
    this.content = content;
  }

  public void updateAnnouncementKind(AnnouncementKind kind) {
    this.kind = kind;
  }

  public void updateRecruitment(int recruitment) {
    this.recruitment = recruitment;
  }

  public void updateStarDate(LocalDateTime starDate) {
    this.starDate = starDate;
  }

  public void updateEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }

  public void updatePeriod(int period) {
    this.period = period;
  }

  public void updateUrl(String url) {
    this.url = url;
  }
}
