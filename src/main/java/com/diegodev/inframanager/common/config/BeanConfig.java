package com.diegodev.inframanager.common.config;

import com.diegodev.inframanager.security.domain.port.out.PasswordEncoderPort;
import com.diegodev.inframanager.user.application.UserService;
import com.diegodev.inframanager.user.domain.port.in.UserUseCase;
import com.diegodev.inframanager.user.domain.port.out.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public UserUseCase userUseCase(UserRepositoryPort repo, PasswordEncoderPort encoder){
        return new UserService(repo, encoder);
    }
}
