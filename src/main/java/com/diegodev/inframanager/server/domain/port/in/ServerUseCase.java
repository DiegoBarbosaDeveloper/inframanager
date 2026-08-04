package com.diegodev.inframanager.server.domain.port.in;

import com.diegodev.inframanager.server.domain.model.Server;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServerUseCase {
    Server registerServer(Server server);
    Server modifyServer(String ip, Server server);
    void deleteServer(String ip);
    Page<Server> searchServerByOs(String os, Pageable pageable);
    Page<Server> searchServerByRam(String ram, Pageable pageable);
    Page<Server> searchServerByStatus(String status, Pageable pageable);
}
