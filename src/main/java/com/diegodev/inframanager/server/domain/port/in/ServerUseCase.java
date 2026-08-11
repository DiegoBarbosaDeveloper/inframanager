package com.diegodev.inframanager.server.domain.port.in;

import com.diegodev.inframanager.server.domain.model.Server;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServerUseCase {

    Page<Server> searchAll(Pageable pageable);
    Server registerServer(Server server);
    Server modifyServerById(Long id, Server server);
    Server modifyServerByIp(String ip, Server server);
    void deleteServer(String ip);

    Page<Server> searchServerByOs(String os, Pageable pageable);
    Page<Server> searchServerByRam(Long ram, Pageable pageable);
    Page<Server> searchByCpu(String cpu, Pageable pageable);
    Page<Server> searchServerByStatus(String status, Pageable pageable);
    Page<Server> searchByLocation(String location, Pageable pageable);
}
