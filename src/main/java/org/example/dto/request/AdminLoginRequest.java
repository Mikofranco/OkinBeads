package org.example.dto.request;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminLoginRequest {
    private String email;
    private String password;
}
