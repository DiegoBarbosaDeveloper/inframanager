package com.diegodev.inframanager.server.domain.port.in;

import com.diegodev.inframanager.server.domain.model.Server;

import java.util.List;

public interface ServerUseCase {
    Server registerServer(Server server);
    Server modifyServer(String ip, Server server);
    void deleteServer(String ip);
    List<Server> searchServer(String by);
}
