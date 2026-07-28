package com.diegodev.inframanager.security.domain.model;

import lombok.Data;

@Data
public class Login {
    private String username;
    private String password;
    private String token;
}
