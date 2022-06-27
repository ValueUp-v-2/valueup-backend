package com.valueup.backend.post.service;

import com.valueup.backend.post.dto.request.AnnouncementRequest;

public interface AnnouncementService {
  Long createPost(AnnouncementRequest request);
}
