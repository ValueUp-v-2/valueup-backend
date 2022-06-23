package com.valueup.backend.post.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DiscriminatorValue("B")
@Getter
public class Announcement extends Post {

    @Column(name = "announcement_kind")
    private String kind; //게시판 종류

    @Column(name = "announcement_recruitment")
    private String recruitment; //모집 인원

    @Column(name = "announcement_start_date")
    private LocalDateTime starDate;//시작 기간

    @Column(name = "announcement_end_date")
    private LocalDateTime endDate;//종료 기간

    @Column(name = "announcement_period")
    private int period; //활동 기간

    @Column(name = "announcement_url")
    private String url; //게시판 홈페이지
}
