package com.valueup.backend.post.service;


import com.valueup.backend.post.domain.Announcement;
import com.valueup.backend.post.domain.Community;
import com.valueup.backend.post.dto.request.CommunityRequest;

import com.valueup.backend.post.dto.request.PageRequestDTO;
import com.valueup.backend.post.dto.response.AnnouncementResponse;
import com.valueup.backend.post.dto.response.CommunityListResponse;
import com.valueup.backend.post.dto.response.CommunityResponse;
import com.valueup.backend.post.dto.response.PageResponse;
import com.valueup.backend.user.domain.User;

public interface CommunityService {

  Long createCommunity(User user, CommunityRequest request);

  PageResponse<CommunityResponse, Community> getListOfCommunity(PageRequestDTO requestDTO);

  CommunityResponse getCommunity(Long id);
  Long updateCommunity(CommunityRequest request, Long id);

  void deleteCommunity(Long id);

  //좋아요
  //boolean  likeCommunity(Long postId);

  boolean bookmarkPost(Long postId, User user);

  default CommunityResponse entityToDto(Community community) {
    CommunityResponse dto = CommunityResponse.builder()
        .id(community.getId())
        .name(community.getName())
        .nickname(community.getUser().getNickname())
        .content(community.getContent())
        .communityCategory(community.getCommunityCategory())
        .views(community.getViews())
        .build();

    return dto;
  }
}
