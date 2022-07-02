package com.valueup.backend.post.service;


import com.valueup.backend.post.dto.request.CommunityRequest;

import com.valueup.backend.post.dto.response.CommunityListResponse;

public interface CommunityService {
  Long createCommunity(CommunityRequest request);

  CommunityListResponse getListOfCommunity();
}
