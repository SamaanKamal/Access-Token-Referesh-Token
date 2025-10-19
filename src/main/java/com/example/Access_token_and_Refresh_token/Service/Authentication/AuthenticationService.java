package com.example.Access_token_and_Refresh_token.Service.Authentication;

import com.example.Access_token_and_Refresh_token.Dto.AuthenticationRequestDto;
import com.example.Access_token_and_Refresh_token.Dto.AuthenticationResponseDto;

public interface AuthenticationService {
    public AuthenticationResponseDto authenticate(AuthenticationRequestDto authenticationRequestDto);
    public AuthenticationResponseDto register(AuthenticationRequestDto authenticationRequestDto);
    public AuthenticationResponseDto refresh(String refreshToken);

}
