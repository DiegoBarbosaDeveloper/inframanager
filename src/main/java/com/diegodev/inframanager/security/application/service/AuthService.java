package com.diegodev.inframanager.security.application.service;

import com.diegodev.inframanager.security.domain.model.Login;
import com.diegodev.inframanager.security.domain.model.Register;
import com.diegodev.inframanager.security.domain.port.in.AuthUseCase;
import com.diegodev.inframanager.security.domain.port.out.PasswordEncoderPort;
import com.diegodev.inframanager.security.domain.port.out.TokenProviderPort;
import com.diegodev.inframanager.security.infrastructure.adapter.in.api.mapper.AuthMapper;
import com.diegodev.inframanager.user.domain.model.Role;
import com.diegodev.inframanager.user.domain.model.User;
import com.diegodev.inframanager.user.domain.port.out.UserRepositoryPort;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

    private final UserRepositoryPort repository;
    private final PasswordEncoderPort encoder;
    private final TokenProviderPort tokenProvider;
    private final AuthMapper authMapper;


    @Override
    public Login login(@NotBlank String email, @NonNull String password) {
        User user = repository.getByEmail(email)
                .orElseThrow(() -> new BadCredentialsException("Email Not Found, watch for your Email"));
        if (!encoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Password is not correct");
        }

        Login newLogin = new Login();
        newLogin.setUsername(user.getUsername());
        newLogin.setPassword(user.getPassword());
        newLogin.setToken(tokenProvider.generateToken(user));

        return newLogin;

    }

    @Override
    public Register register(@NonNull User user) {

        if(user.getEmail().isBlank()){
            throw new RuntimeException("Email Not Valid");
        }

        if(repository.existByEmail(user.getEmail())){
            throw new RuntimeException("User Already Exist");
        }

        user.setRole(Role.VIEWER);
        Register register = authMapper.toRegister(user);
        register.setPassword(encoder.encode(register.getPassword()));

        register.setToken(tokenProvider.generateToken(repository.save(user)));

        return register;
    }
}
