package com.example.Access_token_and_Refresh_token.Service.Authentication;

import com.example.Access_token_and_Refresh_token.Dto.AuthenticationRequestDto;
import com.example.Access_token_and_Refresh_token.Dto.AuthenticationResponseDto;
import com.example.Access_token_and_Refresh_token.Entity.User;
import com.example.Access_token_and_Refresh_token.Repository.UserRepository;
import com.example.Access_token_and_Refresh_token.Service.User.UserService;
import com.example.Access_token_and_Refresh_token.Utilities.JWTService;
import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImp implements AuthenticationService{
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserRepository userRepository;
    private final com.example.Access_token_and_Refresh_token.Utilities.UserDetails usDetails;

    @Override
    public AuthenticationResponseDto authenticate(AuthenticationRequestDto authenticationRequestDto) {
        String username = authenticationRequestDto.getUsername();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
                authenticationRequestDto.getPassword()));
        UserDetails userDetails = usDetails.loadUserByUsername(username);
        String jwtToken  = jwtService.generateToken(userDetails);
        String refreshToken = jwtService.generateRefreshToken(userDetails);
        return new AuthenticationResponseDto(jwtToken, refreshToken);
    }

    @Override
    public AuthenticationResponseDto register(AuthenticationRequestDto authenticationRequestDto) {
        String username = authenticationRequestDto.getUsername();
        User user = userRepository.findByUsername(username);
        userService.saveUser(user);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
                authenticationRequestDto.getPassword()));
        UserDetails userDetails = usDetails.loadUserByUsername(username);
        String jwtToken  = jwtService.generateToken(userDetails);
        String refreshToken = jwtService.generateRefreshToken(userDetails);
        return new AuthenticationResponseDto(jwtToken, refreshToken);
    }

    @Override
    public AuthenticationResponseDto refresh(String refreshToken) {
        String username = jwtService.extractUsername(refreshToken);
        UserDetails userDetails = usDetails.loadUserByUsername(username);
        if(jwtService.isTokenValid(refreshToken, userDetails)){
           String accessToken = jwtService.generateToken(userDetails);
           return new AuthenticationResponseDto(accessToken, refreshToken);
        }
        return null;
    }
}
