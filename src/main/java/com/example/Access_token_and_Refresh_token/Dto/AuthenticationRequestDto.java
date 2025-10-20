package com.example.Access_token_and_Refresh_token.Dto;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;
}
