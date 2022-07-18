package com.valueup.backend.post.controller;

import com.valueup.backend.bookmark.dto.response.BookmarkResponse;
import com.valueup.backend.post.dto.request.CommunityRequest;
import com.valueup.backend.post.dto.response.CommunityListResponse;
import com.valueup.backend.post.service.CommunityService;
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
public class CommunityController {

  private final CommunityService communityService;

  //user 있는지(로그인) 확인하는 메서드, 공고에서는 유저 권한 확인도 필요


  @PostMapping("/community")
  public ResponseEntity<Long> createCommunity(@Valid @RequestBody CommunityRequest request,
      HttpSession session,
      BindingResult result) {
    User user = (User) session.getAttribute("user");
    Long id = communityService.createCommunity(user, request);
    if (result.hasErrors()) {
      //return ""; 다시 글 작성 페이지로
    }
    //성공하면 글 목록으로
    return new ResponseEntity<>(id, HttpStatus.OK);
  }

  @GetMapping("/community")
  public ResponseEntity<CommunityListResponse> getListOfCommunity() {
    CommunityListResponse communityListResponse = communityService.getListOfCommunity();
    return new ResponseEntity<>(communityListResponse, HttpStatus.OK);
  }

  @PatchMapping("/community/{id}")
  public ResponseEntity<Long> updateCommunity(
      @Valid @RequestBody CommunityRequest request, @PathVariable Long id,
      BindingResult result) {
    Long updateId = communityService.updateCommunity(request, id);
    if (result.hasErrors()) {
      //return ""; 다시 글 작성 페이지로
    }
    //성공하면 글 목록으로
    return new ResponseEntity<>(updateId, HttpStatus.OK);
  }

  @DeleteMapping("/community/{id}")
  public ResponseEntity<Void> deleteCommunity(@PathVariable Long id) {
    communityService.deleteCommunity(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/community/bookmarks{id}")
  public ResponseEntity<BookmarkResponse> bookmarkCommunity(@PathVariable Long id,
      HttpSession session){
    User user = (User) session.getAttribute("user");
    return ResponseEntity.ok(new BookmarkResponse(communityService.bookmarkPost(id, user)));
  }
}
