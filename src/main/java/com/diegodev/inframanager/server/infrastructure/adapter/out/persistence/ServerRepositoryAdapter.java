package com.diegodev.inframanager.server.infrastructure.adapter.out.persistence;

import com.diegodev.inframanager.server.domain.model.Server;
import com.diegodev.inframanager.server.domain.port.out.ServerRepositoryPort;
import com.diegodev.inframanager.server.infrastructure.adapter.in.api.mapper.ServerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
@RequiredArgsConstructor
public class ServerRepositoryAdapter implements ServerRepositoryPort {

    private final ServerJpaRepository serverJpaRepository;
    private final ServerMapper serverMapper;


    @Override
    public Server saveServer(Server server) {
        ServerEntity toSave = serverMapper.toEntityFromDomain(server);
        ServerEntity saved = serverJpaRepository.save(toSave);
        return serverMapper.toDomainFromEntity(saved);
    }

    @Override
    public void deleteServerByIp(String ip) {
        if (!serverJpaRepository.existsByIp(ip)){
            throw new RuntimeException("Server Does Not Exist or Not Exist");
        }
        serverJpaRepository.deleteByIp(ip);
    }

    @Override
    public Page<Server> getAllServer(Pageable pageable) {
        return serverJpaRepository.findAll(pageable)
                .map(serverMapper::toDomainFromEntity);
    }

    @Override
    public Page<Server> getByOS(PersistenceOperativeSystem os, Pageable pageable) {
        return serverJpaRepository.findAllByOs(os, pageable)
                .map(serverMapper::toDomainFromEntity);
    }

    @Override
    public Page<Server> getByRam(Long ram, Pageable pageable) {
        return serverJpaRepository.findAllByRam(ram, pageable)
                .map(serverMapper::toDomainFromEntity);
    }

    @Override
    public Page<Server> getByStatus(PersistenceServerStatus status, Pageable pageable) {
        return serverJpaRepository.findAllByStatus(status, pageable)
                .map(serverMapper::toDomainFromEntity);
    }

    @Override
    public Page<Server> getByLocation(String location, Pageable pageable) {
        return serverJpaRepository.findAllByLocation(location, pageable)
                .map(serverMapper::toDomainFromEntity);
    }

    @Override
    public boolean existByIp(String ip) {
        return serverJpaRepository.existsByIp(ip);
    }


}
