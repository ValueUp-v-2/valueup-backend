package com.valueup.backend.post.service;

import com.valueup.backend.post.domain.Announcement;
import com.valueup.backend.post.dto.request.AnnouncementRequest;
import com.valueup.backend.post.dto.request.PageRequestDTO;
import com.valueup.backend.post.dto.response.AnnouncementListResponse;
import com.valueup.backend.post.dto.response.AnnouncementResponse;
import com.valueup.backend.post.dto.response.PageResponse;
import com.valueup.backend.user.domain.User;


public interface AnnouncementService {

  Long createAnnouncement(User user, AnnouncementRequest request);

  PageResponse<AnnouncementResponse, Announcement> getListOfAnnouncement(PageRequestDTO requestDTO);

  AnnouncementResponse getAnnouncement(Long id);

  Long updateAnnouncement(AnnouncementRequest request, Long id);

  void deleteAnnouncement(Long id);

  boolean bookmarkPost(Long postId, User user);

  default AnnouncementResponse entityToDto(Announcement announcement) {
    AnnouncementResponse dto = AnnouncementResponse.builder()
        .id(announcement.getId())
        .name(announcement.getName())
        .nickname(announcement.getUser().getNickname())
        .content(announcement.getContent())
        .kind(announcement.getKind())
        .recruitment(announcement.getRecruitment())
        .starDate(announcement.getStarDate())
        .endDate(announcement.getEndDate())
        .period(announcement.getPeriod()).url(announcement.getUrl())
        .views(announcement.getViews())
        .build();

    return dto;

  }
}
