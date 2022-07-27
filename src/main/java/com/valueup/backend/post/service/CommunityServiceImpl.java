package com.valueup.backend.post.service;


import com.valueup.backend.bookmark.domain.Bookmark;
import com.valueup.backend.bookmark.repsoitory.BookmarkRepository;
import com.valueup.backend.post.domain.Announcement;
import com.valueup.backend.post.domain.Community;
import com.valueup.backend.post.dto.request.CommunityRequest;

import com.valueup.backend.post.dto.request.PageRequestDTO;
import com.valueup.backend.post.dto.response.AnnouncementResponse;
import com.valueup.backend.post.dto.response.CommunityListResponse;
import com.valueup.backend.post.dto.response.CommunityResponse;
import com.valueup.backend.post.dto.response.PageResponse;
import com.valueup.backend.post.repository.CommunityRepository;
import com.valueup.backend.user.domain.User;
import com.valueup.backend.user.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CommunityServiceImpl implements CommunityService {

  private final CommunityRepository communityRepository;
  private final UserRepository userRepository;
  private final BookmarkRepository bookmarkRepository;

  @Transactional
  @Override
  public Long createCommunity(User user, CommunityRequest request) {
    Community community = request.DtoToCommunity(request);
    communityRepository.save(community);
    return community.getId();
  }

  @Transactional
  @Override
  public PageResponse<CommunityResponse, Community> getListOfCommunity(PageRequestDTO requestDTO) {
    Pageable pageable = requestDTO.getPageable(Sort.by("id").descending());//상품 정렬
    Page<Community> result = communityRepository.findAll(pageable);

    Function<Community, CommunityResponse> fn = (entity -> entityToDto(entity));
    return new PageResponse<>(result, fn);
  }

  @Override
  public CommunityResponse getCommunity(Long id) {
    Community community = communityRepository.findById(id).orElse(null);
    CommunityResponse communityResponse = entityToDto(community);
    return communityResponse;
  }

  @Override
  public Long updateCommunity(CommunityRequest request, Long id) {
    Community community = communityRepository.findById(id).orElse(null);
    community.updateName(request.getName());
    community.updateContent(request.getContent());
    community.updateCommunityCategory(request.getCommunityCategory());
    communityRepository.save(community);
    return community.getId();
  }

  @Override
  public void deleteCommunity(Long id) {
    Community community = communityRepository.findById(id).orElse(null);
    communityRepository.delete(community);
  }

  @Override
  public boolean bookmarkPost(Long postId, User user) {
    User writer = userRepository.findById(user.getId()).orElse(null);
    Community community = communityRepository.findById(postId).orElse(null);

    Optional<Bookmark> bookmark = bookmarkRepository.findByUserAndPost(writer, community);

    if (bookmark.isEmpty()) {
      bookmarkRepository.save(Bookmark.createBookmark(community, user));
      return true;
    }
    bookmarkRepository.delete(bookmark.get());
    return false;
  }



}
