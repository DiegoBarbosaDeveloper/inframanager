package com.diegodev.inframanager.user.infrastructure.adapter.in.api.dto;

import com.diegodev.inframanager.user.domain.model.User;
import com.diegodev.inframanager.user.infrastructure.adapter.out.persistence.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    User toDomainFromRequest(UserRequest request);
    User toDomainFromEntity(UserEntity entity);
    @Mapping(target = "password", ignore = true)
    UserResponse toResponse(User user);
    UserEntity toEntity(User user);
}
