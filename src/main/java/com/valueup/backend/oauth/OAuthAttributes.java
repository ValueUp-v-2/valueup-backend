package com.valueup.backend.oauth;

import com.valueup.backend.user.domain.User;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class OAuthAttributes {

  private String name;
  private String email;
  private String nameAttributeKey;
  private Map<String, Object> attributes;

  private static final String NAVER = "naver";
  private static final String GITHUB = "github";

  public static OAuthAttributes of(String registrationId, String userNameAttributeName,
      Map<String, Object> attributes) {
    if (registrationId.equals(NAVER)) {
      return ofNaver(userNameAttributeName, attributes);
    } else if (registrationId.equals(GITHUB)) {
      return ofGithub(userNameAttributeName, attributes);
    }
    return ofGoogle(userNameAttributeName, attributes);
  }

  private static final String GOOGLE_ATTRIBUTE_NAME = "name";
  private static final String GOOGLE_ATTRIBUTE_EMAIL = "email";

  private static OAuthAttributes ofGoogle(String userNameAttributeName,
      Map<String, Object> attributes) {
    return OAuthAttributes.builder()
        .name((String) attributes.get(GOOGLE_ATTRIBUTE_NAME))
        .email((String) attributes.get(GOOGLE_ATTRIBUTE_EMAIL))
        .attributes(attributes)
        .nameAttributeKey(userNameAttributeName)
        .build();
  }

  private static final String NAVER_ATTRIBUTE_PATH = "response";
  private static final String NAVER_ATTRIBUTE_NAME = "name";
  private static final String NAVER_ATTRIBUTE_EMAIL = "email";

  private static OAuthAttributes ofNaver(String userNameAttributeName,
      Map<String, Object> attributes) {
    Map<String, Object> naverAttributes = (Map<String, Object>) attributes.get(
        NAVER_ATTRIBUTE_PATH);
    return OAuthAttributes.builder()
        .name((String) naverAttributes.get(NAVER_ATTRIBUTE_NAME))
        .email((String) naverAttributes.get(NAVER_ATTRIBUTE_EMAIL))
        .attributes(attributes)
        .nameAttributeKey(userNameAttributeName)
        .build();
  }

  private static final String GITHUB_ATTRIBUTE_NAME = "name";
  private static final String GITHUB_ATTRIBUTE_EMAIL = "html_url";

  private static OAuthAttributes ofGithub(String userNameAttributeName,
      Map<String, Object> attributes) {
    return OAuthAttributes.builder()
        .name((String) attributes.get(GITHUB_ATTRIBUTE_NAME))
        .email((String) attributes.get(GITHUB_ATTRIBUTE_EMAIL))
        .attributes(attributes)
        .nameAttributeKey(userNameAttributeName)
        .build();
  }

  @Builder
  public OAuthAttributes(String name, String email, String nameAttributeKey,
      Map<String, Object> attributes) {
    this.name = name;
    this.email = email;
    this.nameAttributeKey = nameAttributeKey;
    this.attributes = attributes;
  }

  public User toEntity() {
    return User.builder()
        .name(name)
        .email(email)
        .build();
  }

  private final static String format = "OAuthAttributes(name=%s, email=%s)";

  @Override
  public String toString() {
    return String.format(format, name, email);
  }
}
