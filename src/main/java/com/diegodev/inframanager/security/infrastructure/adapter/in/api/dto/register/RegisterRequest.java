package com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.register;

import jakarta.validation.constraints.Email;

public record RegisterRequest(
        String username,
        String password,
        @Email
        String email
) {
}
