package com.valueup.backend.post.service;

import com.valueup.backend.post.domain.Announcement;
import com.valueup.backend.post.dto.request.AnnouncementRequest;
import com.valueup.backend.post.dto.response.AnnouncementListResponse;
import com.valueup.backend.post.dto.response.AnnouncementResponse;
import com.valueup.backend.post.repository.AnnouncementRepository;
import com.valueup.backend.user.domain.User;
import com.valueup.backend.user.repository.UserRepository;
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
  private final UserRepository userRepository;

  @Transactional
  @Override
  public Long createAnnouncement(User user, AnnouncementRequest request) {
    User writer = userRepository.findById(user.getId()).orElse(null);//추후 예외처리?
    Announcement announcement = request.DtoToAnnouncement(request, writer);
    announcementRepository.save(announcement);
    return announcement.getId();
  }

  @Transactional
  @Override
  public AnnouncementListResponse getListOfAnnouncement() {
    List<Announcement> announcements = announcementRepository.findAll();

    List<AnnouncementResponse> announcementResponses = announcements.stream()
        .map( a -> new AnnouncementResponse(a)).collect(
            Collectors.toList());
    AnnouncementListResponse announcementListResponse = new AnnouncementListResponse(
        announcementResponses);
    return announcementListResponse;
  }

  @Transactional
  @Override
  public AnnouncementResponse getAnnouncement(Long id) {
    Announcement announcement = announcementRepository.findById(id).orElse(null);
    AnnouncementResponse announcementResponse = new AnnouncementResponse(announcement);
    return announcementResponse;
  }
}
