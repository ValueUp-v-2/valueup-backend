package com.valueup.backend.post.service;

import com.valueup.backend.bookmark.domain.Bookmark;
import com.valueup.backend.bookmark.repsoitory.BookmarkRepository;
import com.valueup.backend.post.domain.Announcement;
import com.valueup.backend.post.dto.request.AnnouncementRequest;
import com.valueup.backend.post.dto.request.PageRequestDTO;
import com.valueup.backend.post.dto.response.AnnouncementListResponse;
import com.valueup.backend.post.dto.response.AnnouncementResponse;
import com.valueup.backend.post.dto.response.PageResponse;
import com.valueup.backend.post.repository.AnnouncementRepository;
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
public class AnnouncementServiceImpl implements AnnouncementService {

  private final AnnouncementRepository announcementRepository;
  private final UserRepository userRepository;
  private final BookmarkRepository bookmarkRepository;


  //공고 등록
  @Transactional
  @Override
  public Long createAnnouncement(User user, AnnouncementRequest request) {
    User writer = userRepository.findById(user.getId()).orElse(null);//추후 예외처리?
    Announcement announcement = request.DtoToAnnouncement(request, writer);
    announcementRepository.save(announcement);
    return announcement.getId();
  }

  //공고 조회
  @Transactional
  @Override
  public PageResponse<AnnouncementResponse, Announcement> getListOfAnnouncement(PageRequestDTO requestDTO) {
    Pageable pageable = requestDTO.getPageable(Sort.by("id").descending());//상품 정렬
    Page<Announcement> result = announcementRepository.findAll(pageable);

    Function<Announcement, AnnouncementResponse> fn = (entity -> entityToDto(entity));
    return new PageResponse<>(result, fn);
  }

  @Transactional
  @Override
  public AnnouncementResponse getAnnouncement(Long id) {
    Announcement announcement = announcementRepository.findById(id).orElse(null);
    AnnouncementResponse announcementResponse = entityToDto(announcement);
    return announcementResponse;
  }

  @Transactional
  @Override
  public Long updateAnnouncement(AnnouncementRequest request, Long id) {
    Announcement announcement = announcementRepository.findById(id).orElse(null);
    announcement.updateName(request.getName());
    announcement.updateContent(request.getContent());
    announcement.updateAnnouncementKind(request.getKind());
    announcement.updateRecruitment(request.getRecruitment());
    announcement.updateStarDate(request.getStarDate());
    announcement.updateEndDate(request.getEndDate());
    announcement.updatePeriod(request.getPeriod());
    announcement.updateUrl(request.getUrl());
    announcementRepository.save(announcement);

    return announcement.getId();
  }

  @Transactional
  @Override
  public void deleteAnnouncement(Long id) {
    Announcement announcement = announcementRepository.findById(id).orElse(null);
    announcementRepository.delete(announcement);
  }

  @Transactional
  @Override
  public boolean bookmarkPost(Long postId, User user) {
    User writer = userRepository.findById(user.getId()).orElse(null);
    Announcement announcement = announcementRepository.findById(postId).orElse(null);

    Optional<Bookmark> bookmark = bookmarkRepository.findByUserAndPost(writer, announcement);

    if (bookmark.isEmpty()) {
      bookmarkRepository.save(Bookmark.createBookmark(announcement, user));
      return true;
    }
    bookmarkRepository.delete(bookmark.get());
    return false;
  }
}
