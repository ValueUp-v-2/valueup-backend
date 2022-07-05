package com.valueup.backend.post.controller;

import com.valueup.backend.post.dto.request.AnnouncementRequest;
import com.valueup.backend.post.dto.response.AnnouncementListResponse;
import com.valueup.backend.post.dto.response.AnnouncementResponse;
import com.valueup.backend.post.service.AnnouncementService;
import com.valueup.backend.user.domain.User;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class AnnouncementController {

  private final AnnouncementService announcementService;

  //user 있는지(로그인) 확인하는 메서드, 공고에서는 유저 권한 확인도 필요


  @PostMapping("/announcement")
  public ResponseEntity<Long> createReview(@Valid @RequestBody AnnouncementRequest request,
      HttpSession session,
      BindingResult result) {
    User user = (User) session.getAttribute("user");
    Long id = announcementService.createAnnouncement(user, request);
    if (result.hasErrors()) {
      //return ""; 다시 글 작성 페이지로
    }
    //성공하면 글 목록으로
    return new ResponseEntity<>(id, HttpStatus.OK);
  }

  @GetMapping("/announcement")
  public ResponseEntity<AnnouncementListResponse> getListOfAnnouncement() {
    AnnouncementListResponse announcementListResponse = announcementService.getListOfAnnouncement();
    return new ResponseEntity<>(announcementListResponse, HttpStatus.OK);
  }

  @GetMapping("/announcement/{id}")
  public ResponseEntity<AnnouncementResponse> getAnnouncement(@PathVariable Long id) {
    AnnouncementResponse announcementResponse = announcementService.getAnnouncement(id);
    return new ResponseEntity<>(announcementResponse, HttpStatus.OK);
  }

  @PatchMapping("/announcement/{id}")
  public ResponseEntity<Long> updateAnnouncement(
      @Valid @RequestBody AnnouncementRequest request, @PathVariable Long id,
      BindingResult result) {
    Long updateId = announcementService.updateAnnouncement(request, id);
    if (result.hasErrors()) {
      //return ""; 다시 글 작성 페이지로
    }
    //성공하면 글 목록으로
    return new ResponseEntity<>(updateId, HttpStatus.OK);
  }

  @DeleteMapping("/announcement/{id}")
  public ResponseEntity<Void> deleteAnnouncement(@PathVariable Long id) {
    announcementService.deleteAnnouncement(id);
    return ResponseEntity.noContent().build();
  }

}
