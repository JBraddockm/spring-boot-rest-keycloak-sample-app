package org.example.controller;

import java.time.Instant;
import java.util.List;
import org.example.DTO.MessageDTO;
import org.example.DTO.UserDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
  @GetMapping("/greet")
  @PreAuthorize("hasAuthority('ADMIN')")
  public MessageDTO getGreeting(Authentication auth) {

    return new MessageDTO(
        "Hi %s! You are granted with: %s.".formatted(auth.getName(), auth.getAuthorities()));
  }

  @GetMapping("/users/me")
  @PreAuthorize("permitAll()")
  public UserDTO getMe(Authentication auth) {
    if (auth instanceof JwtAuthenticationToken jwt) {
      final var username = jwt.getName();
      final var roles = jwt.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
      final var exp = (Instant) jwt.getToken().getExpiresAt();
      assert exp != null;
      return new UserDTO(username, roles, exp.getEpochSecond());
    }
    return new UserDTO("", List.of(), Long.MAX_VALUE);
  }
}
