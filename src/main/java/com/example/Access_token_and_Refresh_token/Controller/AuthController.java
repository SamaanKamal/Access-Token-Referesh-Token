package com.example.Access_token_and_Refresh_token.Controller;

import com.example.Access_token_and_Refresh_token.Dto.AuthenticationRequestDto;
import com.example.Access_token_and_Refresh_token.Dto.AuthenticationResponseDto;
import com.example.Access_token_and_Refresh_token.Service.Authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDto> register(@RequestBody AuthenticationRequestDto authenticationRequestDto){
        return ResponseEntity.ok(authenticationService.register(authenticationRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> login(@RequestBody AuthenticationRequestDto authenticationRequestDto){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequestDto));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthenticationResponseDto> refresh(@RequestParam String refreshToken){
        return ResponseEntity.ok(authenticationService.refresh(refreshToken));
    }
}
