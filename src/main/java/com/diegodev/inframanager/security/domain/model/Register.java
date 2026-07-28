package com.diegodev.inframanager.security.domain.model;

import lombok.Data;

@Data
public class Register {

    private String username;
    private String password;
    private String email;
    private String token;

}
