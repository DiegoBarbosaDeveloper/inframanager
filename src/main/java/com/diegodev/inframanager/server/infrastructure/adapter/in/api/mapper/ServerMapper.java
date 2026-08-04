package com.diegodev.inframanager.server.infrastructure.adapter.in.api.mapper;


import com.diegodev.inframanager.server.domain.model.Server;
import com.diegodev.inframanager.server.infrastructure.adapter.in.api.dto.ServerRequest;
import com.diegodev.inframanager.server.infrastructure.adapter.in.api.dto.ServerResponse;
import com.diegodev.inframanager.server.infrastructure.adapter.out.persistence.ServerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServerMapper {

    Server toDomainFromRequest(ServerRequest request);
    ServerResponse toResponseFromDomain(Server server);
    ServerEntity toEntityFromDomain(Server server);
    Server toDomainFromEntity(ServerEntity entity);

}
