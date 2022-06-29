package com.valueup.backend.post.service;

import com.valueup.backend.post.domain.Announcement;
import com.valueup.backend.post.dto.request.AnnouncementRequest;
import com.valueup.backend.post.dto.response.AnnouncementListResponse;
import com.valueup.backend.post.dto.response.AnnouncementResponse;
import com.valueup.backend.post.repository.AnnouncementRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

  private final AnnouncementRepository announcementRepository;

  @Transactional
  @Override
  public Long createAnnouncement(AnnouncementRequest request) {
    Announcement announcement = request.DtoToAnnouncement(request);
    announcementRepository.save(announcement);
    return announcement.getId();
  }

  @Transactional
  @Override
  public AnnouncementListResponse getListOfAnnouncement() {
    List<Announcement> announcements = announcementRepository.findAll();
    List<AnnouncementResponse> announcementResponses = announcements.stream()
        .map(a -> new AnnouncementResponse(a)).collect(
            Collectors.toList());
    AnnouncementListResponse announcementListResponse = new AnnouncementListResponse(
        announcementResponses);
    return announcementListResponse;
  }
}
