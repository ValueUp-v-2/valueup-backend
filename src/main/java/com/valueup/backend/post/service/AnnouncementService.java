package com.valueup.backend.post.service;

import com.valueup.backend.post.dto.request.AnnouncementRequest;
import com.valueup.backend.post.dto.response.AnnouncementListResponse;
import com.valueup.backend.post.dto.response.AnnouncementResponse;
import com.valueup.backend.user.domain.User;


public interface AnnouncementService {

  Long createAnnouncement(User user, AnnouncementRequest request);

  AnnouncementListResponse getListOfAnnouncement();

  AnnouncementResponse getAnnouncement(Long id);

  Long updateAnnouncement(AnnouncementRequest request, Long id);

  void deleteAnnouncement(Long id);

  boolean bookmarkPost(Long postId, User user);
}
