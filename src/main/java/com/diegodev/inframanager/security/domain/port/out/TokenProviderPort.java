package com.diegodev.inframanager.security.domain.port.out;

import com.diegodev.inframanager.user.domain.model.User;

public interface TokenProviderPort {
    String generateToken(User user);
    String getEmail(String token);
    boolean isValid(String token);
}
