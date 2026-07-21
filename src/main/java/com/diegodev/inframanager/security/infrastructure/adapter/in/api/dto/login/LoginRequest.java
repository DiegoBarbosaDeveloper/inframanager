package com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.login;

public record LoginRequest(
        String username,
        String password

) {
}
