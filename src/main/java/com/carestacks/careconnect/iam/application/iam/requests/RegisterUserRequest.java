package com.carestacks.careconnect.iam.application.iam.requests;

import com.carestacks.careconnect.iam.domain.iam.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterUserRequest {

    @NotBlank(message = "Ingresa tu correo electrónico")
    @Email(message = "Ingresa un correo electrónico válido")
    private String email;

    @NotBlank(message = "Ingresa tu contraseña")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d).+$",
            message = "La contraseña debe incluir al menos una mayúscula y un número"
    )
    private String password;

    @NotBlank(message = "Ingresa tu nombre completo")
    @Size(max = 150, message = "El nombre completo no debe superar 150 caracteres")
    private String fullName;

    @NotNull(message = "Selecciona si eres paciente o cuidador")
    private UserRole role;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public UserRole getRole() { return role; }
    public void setRole(UserRole role) { this.role = role; }
}
