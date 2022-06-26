package com.valueup.backend.controller;

import com.valueup.backend.user.domain.User;
import com.valueup.backend.user.dto.NicknameRequestDto;
import com.valueup.backend.user.repository.UserRepository;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

  private final UserRepository userRepository;

  @GetMapping("/login")
  public String loginForm() {
    return "login";
  }

  @GetMapping("/nickname")
  public String nicknameForm(HttpSession session, Model model) {
    User user = (User) session.getAttribute("user");
    if (user.getNickname() == null) {
      model.addAttribute("nicknameDto", new NicknameRequestDto());
      return "nickname";
    }
    return "index";
  }

  @PostMapping("/nickname")
  public String setNickname(HttpSession session, NicknameRequestDto requestDto) {
    User user = (User) session.getAttribute("user");
    user.setNickname(requestDto.getNickname());
    userRepository.save(user);
    return "index";
  }
}
