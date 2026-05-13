package com.carestacks.careconnect.iam.interfaces;

import com.carestacks.careconnect.iam.application.abstractions.AuthService;
import com.carestacks.careconnect.iam.application.iam.dtos.UserDto;
import com.carestacks.careconnect.iam.application.iam.requests.LoginRequest;
import com.carestacks.careconnect.iam.application.iam.requests.LoginResponse;
import com.carestacks.careconnect.iam.application.iam.requests.RegisterUserRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@Valid @RequestBody RegisterUserRequest request) {
        var loginResponse = authService.register(request);
        var userDto = authService.getCurrentUser(
                authService.getUserIdFromToken(loginResponse.token()));
        return ResponseEntity.created(URI.create("/api/auth/me")).body(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            var jwt = token.substring(7);
            authService.logout(authService.getUserIdFromToken(jwt));
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser(@RequestHeader("Authorization") String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().build();
        }
        var jwt = token.substring(7);
        var userId = authService.getUserIdFromToken(jwt);
        var userDto = authService.getCurrentUser(userId);
        return ResponseEntity.ok(userDto);
    }
}