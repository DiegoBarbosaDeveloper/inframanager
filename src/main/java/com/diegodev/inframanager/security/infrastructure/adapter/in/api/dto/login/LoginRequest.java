package com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @Email @NotBlank String email,
        @NotBlank String password

) {
}
