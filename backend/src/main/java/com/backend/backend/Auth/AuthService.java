package com.backend.backend.Auth;

import com.backend.backend.JWT.JwtService;
import com.backend.backend.Usuario.Usuario;
import com.backend.backend.Usuario.Usuario_Repository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final Usuario_Repository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getNro_registro(), request.getPassword()));
        UserDetails user = userRepository.findByNroRegistro(request.getNro_registro()).orElseThrow();
        String token = jwtService.getToken(user);
        System.out.println(token);
        return AuthResponse.builder()
                .token(token)
                .build();
    }


}
