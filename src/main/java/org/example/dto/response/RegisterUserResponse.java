package org.example.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder @Getter @Setter
public class RegisterUserResponse {
    private  String message ;
    private String username;
}
