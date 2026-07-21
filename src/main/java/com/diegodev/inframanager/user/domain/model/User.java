package com.diegodev.inframanager.user.domain.model;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

/*
    Modelo sin frameworks externos
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UUID id;
    private String username;
    @NonNull
    private String password;
    @Email
    private String email;
    private Role role;
}
