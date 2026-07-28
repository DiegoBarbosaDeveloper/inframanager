package com.diegodev.inframanager.security.infrastructure.adapter.in.api;

import com.diegodev.inframanager.security.domain.port.in.AuthUseCase;
import com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.login.LoginRequest;
import com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.login.LoginResponse;
import com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.register.RegisterRequest;
import com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.register.RegisterResponse;
import com.diegodev.inframanager.security.infrastructure.adapter.in.api.mapper.AuthMapper;
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

    private final AuthMapper authMapper;
    private final AuthUseCase authUseCase;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {


        return ResponseEntity.ok(
                authMapper.toLoginResponse(
                        authUseCase.login(request.email(), request.password())
                )
        );

    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {

        return ResponseEntity.ok(
                authMapper.toRegisterResponse(
                        authUseCase.register(authMapper.toDomainFromRequest(request))
                )
        );
    }

}
