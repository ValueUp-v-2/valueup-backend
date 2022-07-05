package com.valueup.backend.post.service;

import com.valueup.backend.comment.repository.CommentRepository;
import com.valueup.backend.post.domain.Announcement;
import com.valueup.backend.post.domain.Community;
import com.valueup.backend.post.dto.request.CommunityRequest;
import com.valueup.backend.post.dto.response.AnnouncementListResponse;
import com.valueup.backend.post.dto.response.AnnouncementResponse;
import com.valueup.backend.post.dto.response.CommunityListResponse;
import com.valueup.backend.post.dto.response.CommunityResponse;
import com.valueup.backend.post.repository.CommunityRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CommunityServiceImpl implements CommunityService {

  private final CommunityRepository communityRepository;

  @Transactional
  @Override
  public Long createCommunity(CommunityRequest request) {
    Community community = request.DtoToCommunity(request);
    communityRepository.save(community);
    return community.getId();
  }

  @Transactional
  @Override
  public CommunityListResponse getListOfCommunity() {
    List<Community> communities = communityRepository.findAll();
    List<CommunityResponse> communityResponses = communities.stream()
        .map(c -> new CommunityResponse(c)).collect(
            Collectors.toList());
    CommunityListResponse communityListResponse = new CommunityListResponse(
        communityResponses);
    return communityListResponse;
  }

  @Override
  public Long updateCommunity(CommunityRequest request, Long id) {
    Community community = communityRepository.findById(id).orElse(null);
    community.updateName(request.getName());
    community.updateContent(request.getContent());
    communityRepository.save(community);
    return community.getId();
  }

  @Override
  public void deleteCommunity(Long id) {
    Community community = communityRepository.findById(id).orElse(null);
    communityRepository.delete(community);
  }

}
