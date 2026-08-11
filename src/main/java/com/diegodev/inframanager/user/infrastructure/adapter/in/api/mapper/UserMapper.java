package com.diegodev.inframanager.user.infrastructure.adapter.in.api.mapper;

import com.diegodev.inframanager.security.domain.model.Register;
import com.diegodev.inframanager.user.domain.model.User;
import com.diegodev.inframanager.user.infrastructure.adapter.in.api.dto.UserRequest;
import com.diegodev.inframanager.user.infrastructure.adapter.in.api.dto.UserResponse;
import com.diegodev.inframanager.user.infrastructure.adapter.out.persistence.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toDomainFromRequest(UserRequest request);

    @Mapping(target = "id", source = "idUser")
    User toDomainFromEntity(UserEntity entity);

    @Mapping(target = "id", source = "id")
    UserResponse toResponse(User user);

    UserEntity toEntity(User user);

}
