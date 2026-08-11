package com.diegodev.inframanager.server.infrastructure.adapter.out.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerJpaRepository extends JpaRepository<ServerEntity, Long> {
    boolean existsByIp(String ip);

    void deleteByIp(String ip);

    Page<ServerEntity> findAllByOs(PersistenceOperativeSystem os, Pageable pageable);

    Page<ServerEntity> findAllByRam(Long ram, Pageable pageable);

    Page<ServerEntity> findAllByStatus(PersistenceServerStatus status, Pageable pageable);

    Page<ServerEntity> findAllByLocation(String location, Pageable pageable);

    Page<ServerEntity> findAllByCpu(String cpu, Pageable pageable);

    ServerEntity findByIp(String ip);
}
