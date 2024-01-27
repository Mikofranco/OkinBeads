package org.example.dto.response;

import lombok.*;
import org.example.data.models.Role;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminLoginResponse {
    private Long id;
    private String username;
    private String email;
    private Role role;
}
