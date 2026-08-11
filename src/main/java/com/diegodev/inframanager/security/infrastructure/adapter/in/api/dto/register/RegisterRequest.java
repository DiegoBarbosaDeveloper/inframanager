package com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.register;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record RegisterRequest(
        @NotBlank(message = "Username Must Not Be Blank Or Null")
        String username,
        @NotBlank(message = "Password Must Not Be Blank")
        @Length(min = 8, message = "Password Must Be At Least 8 Character Long")
        String password,
        @Email(message = "Email Must Contain @ And A Domain")
        @NotBlank(message = "Email Must Not Be Blank")
        String email
) {
}
