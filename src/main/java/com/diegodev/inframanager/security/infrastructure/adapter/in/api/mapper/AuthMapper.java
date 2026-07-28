package com.diegodev.inframanager.security.infrastructure.adapter.in.api.mapper;

import com.diegodev.inframanager.security.domain.model.Login;
import com.diegodev.inframanager.security.domain.model.Register;
import com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.login.LoginRequest;
import com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.login.LoginResponse;
import com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.register.RegisterRequest;
import com.diegodev.inframanager.security.infrastructure.adapter.in.api.dto.register.RegisterResponse;
import com.diegodev.inframanager.user.domain.model.Role;
import com.diegodev.inframanager.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    LoginResponse toLoginResponse(Login domain);

    RegisterResponse toRegisterResponse(Register domain);

    Register toDomainRegister(RegisterRequest request);

    User toDomainFromAuth(Register register);

    Register toRegister(User user);

    User toDomainFromRequest(RegisterRequest request);


}
