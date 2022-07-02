package com.valueup.backend.user.controller;

import com.valueup.backend.user.domain.User;
import com.valueup.backend.user.dto.NicknameRequestDto;
import com.valueup.backend.user.repository.UserRepository;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

  private final UserRepository userRepository;

  @GetMapping("/userinfo")
  public User userInfo(HttpSession session) {
    User user = (User) session.getAttribute("user");
    return user;
  }

  @PostMapping("/nickname")
  public User setNickname(HttpSession session, NicknameRequestDto requestDto) {
    User user = (User) session.getAttribute("user");
    user.setNickname(requestDto.getNickname());
    userRepository.save(user);
    return user;
  }
}
