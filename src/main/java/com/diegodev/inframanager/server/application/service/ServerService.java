package com.diegodev.inframanager.server.application.service;

import com.diegodev.inframanager.server.domain.model.OperativeSystem;
import com.diegodev.inframanager.server.domain.model.Server;
import com.diegodev.inframanager.server.domain.model.ServerStatus;
import com.diegodev.inframanager.server.domain.port.in.ServerUseCase;
import com.diegodev.inframanager.server.domain.port.out.ServerRepositoryPort;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Service
@Transactional
@RequiredArgsConstructor
public class ServerService implements ServerUseCase {

    private final ServerRepositoryPort serverRepository;

    @Override
    public Page<Server> searchAll(@NonNull Pageable pageable) {
        return serverRepository.getAllServer(pageable);
    }

    @Override
    public Server registerServer(@NonNull Server server) {
        return serverRepository.saveServer(server);
    }

    @Override
    public Server modifyServerById(Long id, Server server) {
        if(!serverRepository.existById(id)){
            throw new RuntimeException("Server Not Found in Database");
        }

        Server toChange = serverRepository.getById(id);

        mapToChange(server, toChange);
        toChange.setIp(server.getIp());

        return serverRepository.saveServer(toChange);
    }

    private void mapToChange(@NonNull Server server, @NonNull Server toChange) {
        toChange.setStatus(server.getStatus());
        toChange.setCloudProvider(server.getCloudProvider());
        toChange.setCpu(server.getCpu());
        toChange.setHostname(server.getHostname());
        toChange.setLocation(server.getLocation());
        toChange.setOs(server.getOs());
        toChange.setRam(server.getRam());
        toChange.setRom(server.getRom());
    }

    @Override
    public Server modifyServerByIp(@NonNull String ip, @NonNull Server server) {

        if(!serverRepository.existByIp(ip)){
            throw new RuntimeException("Server Not Found in Database");
        }

        Server toChange = serverRepository.getByIp(ip);

        mapToChange(server, toChange);

        return serverRepository.saveServer(toChange);
    }

    @Override
    public void deleteServer(@NotBlank String ip) {

        if(!serverRepository.existByIp(ip)){
            throw new RuntimeException("Server Already Does Not Exist");
        }

        serverRepository.deleteServerByIp(ip);

    }

    @Override
    public Page<Server> searchServerByOs(@NotBlank String os, @NonNull Pageable pageable) {

        var toEnum = OperativeSystem.valueOf(os.toUpperCase(Locale.ROOT));

        return serverRepository.getByOS(toEnum, pageable);
    }

    @Override
    public Page<Server> searchServerByRam(@NonNull Long ram, @NonNull Pageable pageable) {
        return serverRepository.getByRam(ram, pageable);
    }

    @Override
    public Page<Server> searchByCpu(String cpu, Pageable pageable) {
        return serverRepository.getByCpu(cpu, pageable);
    }

    @Override
    public Page<Server> searchServerByStatus(@NotBlank String status, @NonNull Pageable pageable) {

        var toEnum = ServerStatus.valueOf(status.toUpperCase(Locale.ROOT));

        return serverRepository.getByStatus(toEnum, pageable);
    }

    @Override
    public Page<Server> searchByLocation(String location, Pageable pageable) {
        return serverRepository.getByLocation(location, pageable);
    }


}
