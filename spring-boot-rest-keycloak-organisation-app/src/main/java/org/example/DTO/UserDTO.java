package org.example.DTO;

import java.util.List;

public record UserDTO(String username, List<String> roles, Long exp) {}
