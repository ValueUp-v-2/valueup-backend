package com.valueup.backend.post.controller;

import com.valueup.backend.post.dto.request.CommunityRequest;
import com.valueup.backend.post.dto.response.CommunityListResponse;
import com.valueup.backend.post.service.CommunityService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
      BindingResult result) {
    Long id = communityService.createCommunity(request);
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
}
