package com.diegodev.inframanager.common.config;

import com.diegodev.inframanager.security.infrastructure.adapter.in.api.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    /*
     * Configuración básica para Spring Security, con el filtro jwt,
     * la cadena de filtro y algunos Beans de configuración para Spring
     */

    private final JwtAuthFilter jwtAuthFilter;
    //private final ApiAccessDeniedHandler apiAccessDeniedHandler;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(cors -> {
                })
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(request ->
                        request
                                .requestMatchers("/auth/**").permitAll()
                                .requestMatchers("/users/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/server").permitAll()
                                .requestMatchers(
                                        "/v3/api-docs/**",
                                        "/v3/api-docs.yaml",
                                        "/swagger-ui/**",
                                        "/swagger-ui.html"
                                ).permitAll()
                                .anyRequest().permitAll()
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        ;

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) {
        return configuration.getAuthenticationManager();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
