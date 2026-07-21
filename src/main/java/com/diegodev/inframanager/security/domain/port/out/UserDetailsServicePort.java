package com.diegodev.inframanager.security.domain.port.out;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsServicePort {
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
