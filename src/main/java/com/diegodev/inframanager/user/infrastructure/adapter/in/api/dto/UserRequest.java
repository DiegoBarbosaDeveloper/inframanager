package com.diegodev.inframanager.user.infrastructure.adapter.in.api.dto;

import com.diegodev.inframanager.user.infrastructure.adapter.in.api.AdapterRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UserRequest(
        @Length(max = 20) String username,
        @NotBlank @Length(min = 8) String password,
        @Email String email,
        AdapterRole role
) {
}
