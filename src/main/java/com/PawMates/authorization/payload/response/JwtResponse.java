package com.PawMates.authorization.payload.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private Long id;
  private String username;
  private String email;
  private List<String> roles;

  public JwtResponse(String jwt, Long id, String username, String email, List<String> roles) {
    this.token = jwt;
    this.id = id;
    this.username = username;
    this.email = email;
    this.roles = roles;

  }
}
