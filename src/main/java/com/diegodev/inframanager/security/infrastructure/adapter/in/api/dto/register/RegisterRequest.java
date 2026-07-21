package com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.register;

public record RegisterRequest(
        String username,
        String password
) {
}
