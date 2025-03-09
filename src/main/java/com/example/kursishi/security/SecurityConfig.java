package com.example.kursishi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
   return http.csrf(AbstractHttpConfigurer::disable)
      .authorizeHttpRequests(
        auth -> auth
          .requestMatchers(
                  "/api/about/**",
            "/api/partners",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "api/auth/sign-in",
            "/api/teachers/**").permitAll()
          .anyRequest().authenticated()
      ).build();
  }
}
