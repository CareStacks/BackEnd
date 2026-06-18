package com.carestacks.careconnect.iam.application.iam.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "Ingresa tu correo electrónico")
    @Email(message = "Ingresa un correo electrónico válido")
    private String email;

    @NotBlank(message = "Ingresa tu contraseña")
    private String password;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
