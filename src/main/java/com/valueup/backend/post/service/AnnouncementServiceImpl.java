package com.valueup.backend.post.service;

import com.valueup.backend.post.domain.Announcement;
import com.valueup.backend.post.dto.request.AnnouncementRequest;
import com.valueup.backend.post.dto.response.AnnouncementListResponse;
import com.valueup.backend.post.repository.AnnouncementRepository;
import com.valueup.backend.post.repository.PostRepository;
import java.util.List;
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

  @Override
  public List<AnnouncementListResponse> getListOfAnnouncement() {
    return null;
  }
}
