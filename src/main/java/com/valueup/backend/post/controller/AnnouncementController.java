package com.valueup.backend.post.controller;

import com.valueup.backend.post.dto.request.AnnouncementRequest;
import com.valueup.backend.post.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class AnnouncementController {
  private final AnnouncementService announcementService;

  @PostMapping("/post")
  public ResponseEntity<Long> createReview(@RequestBody AnnouncementRequest request){
    Long id = announcementService.createPost(request);
    return new ResponseEntity<>(id, HttpStatus.OK);
  }
}
