package com.valueup.backend.config;

import com.valueup.backend.oauth.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {


  private final CustomOAuth2UserService customOAuth2UserService;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeRequests(a -> a
            .antMatchers("/", "/login", "/h2-console/**").permitAll()
            .antMatchers(HttpMethod.POST,"/v1/users/announcement").hasRole("ENTERPRISE")
            .antMatchers(HttpMethod.PATCH,"/v1/users/announcement/**").hasRole("ENTERPRISE")
            .antMatchers(HttpMethod.DELETE,"/v1/users/announcement/**").hasRole("ENTERPRISE")
            .anyRequest().authenticated()
        )
        .exceptionHandling(e -> e
            .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
        )
        .csrf().disable()
        .headers(h -> h
            .frameOptions().sameOrigin()
        )
        .formLogin(l -> l
            .defaultSuccessUrl("/userinfo")
        )
        .logout(l -> l
            .logoutSuccessUrl("/login").permitAll()
        )
        .oauth2Login(o -> o
            .loginPage("/login")
            .defaultSuccessUrl("/userinfo")
            .userInfoEndpoint().userService(customOAuth2UserService));

    return http.build();
  }
}
