package com.diegodev.inframanager.user.infrastructure.adapter.in.api.dto;

import com.diegodev.inframanager.user.domain.model.Role;
import jakarta.validation.constraints.Email;

public record UserRequest(
        String username,
        String password,
        @Email String email,
        Role role
) {
}
