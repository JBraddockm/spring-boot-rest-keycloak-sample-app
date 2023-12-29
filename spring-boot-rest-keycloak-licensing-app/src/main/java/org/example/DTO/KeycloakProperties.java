package org.example.DTO;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class KeycloakProperties {

  @Value("${oauth2-client-id}")
  private String clientID;

  @Value("${oauth2-client-secret}")
  private String clientSecret;
}
