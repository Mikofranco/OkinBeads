package org.example.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterAdminRequest {
    private String username;
    private String email;
    private String password;
}
