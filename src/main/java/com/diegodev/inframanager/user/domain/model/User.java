package com.diegodev.inframanager.user.domain.model;

import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.UUID;

/*
    Modelo sin frameworks externos
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UUID id;
    private String username;
    private String password;
    private String email;
    private Role role;

}
