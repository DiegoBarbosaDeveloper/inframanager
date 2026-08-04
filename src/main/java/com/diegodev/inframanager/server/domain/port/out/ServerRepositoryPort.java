package com.diegodev.inframanager.server.domain.port.out;

import com.diegodev.inframanager.server.domain.model.Server;
import com.diegodev.inframanager.server.infrastructure.adapter.out.persistence.PersistenceOperativeSystem;
import com.diegodev.inframanager.server.infrastructure.adapter.out.persistence.PersistenceServerStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServerRepositoryPort {
    Server saveServer(Server server);
    void deleteServerByIp(String ip);
    Page<Server> getAllServer(Pageable pageable);
    Page<Server> getByOS(PersistenceOperativeSystem os, Pageable pageable);
    Page<Server> getByRam(Long ram, Pageable pageable);
    Page<Server> getByStatus(PersistenceServerStatus status, Pageable pageable);
    Page<Server> getByLocation(String location, Pageable pageable);
    boolean existByIp(String ip);
}
