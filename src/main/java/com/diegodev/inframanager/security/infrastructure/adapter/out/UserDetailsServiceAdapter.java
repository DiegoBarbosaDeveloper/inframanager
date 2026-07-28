package com.diegodev.inframanager.security.infrastructure.adapter.out;

import com.diegodev.inframanager.security.domain.port.out.UserDetailsServicePort;
import com.diegodev.inframanager.user.domain.model.User;
import com.diegodev.inframanager.user.domain.port.out.UserRepositoryPort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceAdapter implements UserDetailsServicePort {

    private final UserRepositoryPort userRepositoryPort;

    public UserDetailsServiceAdapter(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepositoryPort.getByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }
}
