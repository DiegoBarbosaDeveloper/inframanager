package com.diegodev.inframanager.security.infrastructure.adapter.in.api;

import com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.login.LoginRequest;
import com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.register.RegisterRequest;
import com.diegodev.inframanager.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthRestApiAdapter {

    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){



        return ResponseEntity.ok(null);

    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){

        return ResponseEntity.ok(request.toString());
    }

}
