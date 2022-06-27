package com.valueup.backend.oauth;

import com.valueup.backend.user.domain.User;
import com.valueup.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
/*import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;*/
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

  private final UserRepository userRepository;
  private final HttpSession httpSession;

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
    OAuth2User oAuth2User = delegate.loadUser(userRequest);

    String registrationId = userRequest.getClientRegistration().getRegistrationId();

    String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
        .getUserInfoEndpoint().getUserNameAttributeName();

    OAuthAttributes authAttributes = OAuthAttributes.of(registrationId, userNameAttributeName,
        oAuth2User.getAttributes());

    User user = saveOrGet(authAttributes);
    httpSession.setAttribute("user", user);

    return oAuth2User;
  }

  private User saveOrGet(OAuthAttributes attributes) {
    Optional<User> userOptional = userRepository.findByEmail(attributes.getEmail());
    User user;
    if (userOptional.isPresent()) {
      user = userOptional.get();
    } else {
      user = attributes.toEntity();
      userRepository.save(user);
    }

    return user;
  }
}
