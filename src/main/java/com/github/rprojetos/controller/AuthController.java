package com.github.rprojetos.controller;

import com.github.rprojetos.jwtsecurity.JwtUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        System.out.println("*********************");
        System.out.println("*********************");
        System.out.println(loginRequest.username);
        System.out.println(loginRequest.password);
        System.out.println("*********************");
        System.out.println("*********************");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        String token = jwtUtils.generateToken(loginRequest.getUsername());
        return ResponseEntity.ok(token);
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class LoginRequest {
        private String username;
        private String password;

        // Getters e Setters
    }
}
