package org.example.dto.response;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.data.models.Role;

@Builder
@Setter
@Getter
public class LoginUserResponse {
    private Long id;
    private String username;
    private String email;
    private Role role;
}
