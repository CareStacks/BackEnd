package com.carestacks.careconnect.iam.application.iam.requests;

public record LoginResponse(String token, String type, Long expiresIn) {
    public static LoginResponse of(String token, long expiresIn) {
        return new LoginResponse(token, "Bearer", expiresIn);
    }
}