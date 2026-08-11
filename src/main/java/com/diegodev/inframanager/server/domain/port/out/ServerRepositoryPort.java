package com.diegodev.inframanager.server.domain.port.out;

import com.diegodev.inframanager.server.domain.model.OperativeSystem;
import com.diegodev.inframanager.server.domain.model.Server;
import com.diegodev.inframanager.server.domain.model.ServerStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServerRepositoryPort {
    Server saveServer(Server server);
    void deleteServerByIp(String ip);
    Server getByIp(String ip);
    Server getById(Long id);
    Page<Server> getAllServer(Pageable pageable);
    Page<Server> getByOS(OperativeSystem os, Pageable pageable);
    Page<Server> getByRam(Long ram, Pageable pageable);
    Page<Server> getByStatus(ServerStatus status, Pageable pageable);
    Page<Server> getByCpu(String cpu, Pageable pageable);
    Page<Server> getByLocation(String location, Pageable pageable);
    boolean existByIp(String ip);
    boolean existById(Long id);
}
