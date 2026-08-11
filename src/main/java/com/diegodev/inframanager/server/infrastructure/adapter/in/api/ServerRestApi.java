package com.diegodev.inframanager.server.infrastructure.adapter.in.api;

import com.diegodev.inframanager.server.infrastructure.adapter.in.api.dto.ServerRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ServerRestApi {

    ResponseEntity<?> getAll(Pageable pageable);

    ResponseEntity<?> getBySystem(String os, Pageable pageable);

    ResponseEntity<?> getByRam(long ram, Pageable pageable);

    ResponseEntity<?> getByCpu(String cpu, Pageable pageable);

    ResponseEntity<?> getByStatus(String status, Pageable pageable);

    ResponseEntity<?> getByLocation(String location, Pageable pageable);

    ResponseEntity<?> postServer(ServerRequest request);

    ResponseEntity<?> putByIp(String ip, ServerRequest request);

    ResponseEntity<?> putById(Long id, ServerRequest request);
}
