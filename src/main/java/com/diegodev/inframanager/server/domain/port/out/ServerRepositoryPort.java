package com.diegodev.inframanager.server.domain.port.out;

import com.diegodev.inframanager.server.domain.model.Server;

public interface ServerRepositoryPort {
    Server saveServer(Server server);
    void deleteServerByIp(String ip);


}
