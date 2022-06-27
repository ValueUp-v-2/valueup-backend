package com.valueup.backend.post.service;

import com.valueup.backend.post.dto.request.AnnouncementRequest;
import com.valueup.backend.post.dto.response.AnnouncementListResponse;
import java.util.List;

public interface AnnouncementService {

  Long createAnnouncement(AnnouncementRequest request);

  List<AnnouncementListResponse> getListOfAnnouncement();
}
