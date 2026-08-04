package com.diegodev.inframanager.user.infrastructure.adapter.in.api.dto;

import com.diegodev.inframanager.user.infrastructure.adapter.in.api.AdapterRole;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        String email,
        AdapterRole role
) {
}
