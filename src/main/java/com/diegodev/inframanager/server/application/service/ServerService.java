package com.diegodev.inframanager.server.application.service;

import com.diegodev.inframanager.server.domain.model.Server;
import com.diegodev.inframanager.server.domain.port.in.ServerUseCase;
import com.diegodev.inframanager.server.domain.port.out.ServerRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServerService implements ServerUseCase {

    private final ServerRepositoryPort serverRepository;

    @Override
    public Server registerServer(Server server) {
        return serverRepository.saveServer(server);
    }

    @Override
    public Server modifyServer(String ip, Server server) {




        return serverRepository.saveServer(server);
    }

    @Override
    public void deleteServer(String ip) {

    }

    @Override
    public Page<Server> searchServerByOs(String os, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Server> searchServerByRam(String ram, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Server> searchServerByStatus(String status, Pageable pageable) {
        return null;
    }
}
