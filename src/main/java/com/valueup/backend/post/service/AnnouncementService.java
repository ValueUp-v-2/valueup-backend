package com.valueup.backend.post.service;

import com.valueup.backend.post.dto.request.AnnouncementRequest;
import com.valueup.backend.post.dto.response.AnnouncementListResponse;


public interface AnnouncementService {

  Long createAnnouncement(AnnouncementRequest request);

  AnnouncementListResponse getListOfAnnouncement();
}
