package com.diegodev.inframanager.security.domain.port.in;

import com.diegodev.inframanager.security.domain.model.Login;
import com.diegodev.inframanager.security.domain.model.Register;
import com.diegodev.inframanager.user.domain.model.User;

public interface AuthUseCase {
    Login login(String email, String password);
    Register register(User user);
}
