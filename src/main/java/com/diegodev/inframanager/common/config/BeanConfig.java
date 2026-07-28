package com.diegodev.inframanager.common.config;

import com.diegodev.inframanager.security.application.service.AuthService;
import com.diegodev.inframanager.security.domain.port.in.AuthUseCase;
import com.diegodev.inframanager.security.domain.port.out.PasswordEncoderPort;
import com.diegodev.inframanager.security.domain.port.out.TokenProviderPort;
import com.diegodev.inframanager.security.infrastructure.adapter.in.api.mapper.AuthMapper;
import com.diegodev.inframanager.user.application.service.UserService;
import com.diegodev.inframanager.user.domain.port.in.UserUseCase;
import com.diegodev.inframanager.user.domain.port.out.UserRepositoryPort;
import com.diegodev.inframanager.user.infrastructure.adapter.in.api.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public UserUseCase userUseCase(UserRepositoryPort repo, PasswordEncoderPort encoder){
        return new UserService(repo, encoder);
    }


    @Bean
    public AuthUseCase authUseCase(UserRepositoryPort repo,
                                   PasswordEncoderPort encoder,
                                   TokenProviderPort tokenProvider,
                                   AuthMapper authMapper){
        return new AuthService(repo, encoder, tokenProvider, authMapper);
    }

}
