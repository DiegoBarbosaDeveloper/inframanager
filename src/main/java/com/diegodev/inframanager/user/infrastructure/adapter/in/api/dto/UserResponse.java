package com.diegodev.inframanager.user.infrastructure.adapter.in.api.dto;

import com.diegodev.inframanager.user.domain.model.Role;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        String email,
        Role role
) {
}
