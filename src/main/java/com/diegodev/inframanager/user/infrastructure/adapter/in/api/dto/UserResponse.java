package com.diegodev.inframanager.user.infrastructure.adapter.in.api.dto;

import com.diegodev.inframanager.user.domain.model.Role;

public record UserResponse(
        Long id,
        String username,
        String email,
        Role role
) {
}
