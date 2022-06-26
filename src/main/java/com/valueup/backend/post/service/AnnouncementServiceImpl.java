package com.valueup.backend.post.service;

import com.valueup.backend.post.domain.Announcement;
import com.valueup.backend.post.dto.request.AnnouncementRequest;
import com.valueup.backend.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

  private final PostRepository postRepository;

  @Transactional
  @Override
  public Long createPost(AnnouncementRequest request) {
    Announcement announcement = request.DtoToAnnouncement(request);
    postRepository.save(announcement);
    return announcement.getId();
  }
}
