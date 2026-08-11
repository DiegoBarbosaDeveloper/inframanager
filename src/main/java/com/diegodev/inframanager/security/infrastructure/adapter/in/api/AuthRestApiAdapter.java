package com.diegodev.inframanager.security.infrastructure.adapter.in.api;

import com.diegodev.inframanager.common.exception.ApiResponse;
import com.diegodev.inframanager.security.domain.port.in.AuthUseCase;
import com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.login.LoginRequest;
import com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.login.LoginResponse;
import com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.register.RegisterRequest;
import com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.register.RegisterResponse;
import com.diegodev.inframanager.security.infrastructure.adapter.in.api.mapper.AuthMapper;
import jakarta.validation.Valid;
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
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(
                ApiResponse.success(
                    authMapper.toLoginResponse(
                            authUseCase.login(request.email(), request.password())
                    )
                )
        );

    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(
                ApiResponse.success(
                    authMapper.toRegisterResponse(
                            authUseCase.register(authMapper.toDomainFromRequest(request))
                    )
                )
        );
    }

}
