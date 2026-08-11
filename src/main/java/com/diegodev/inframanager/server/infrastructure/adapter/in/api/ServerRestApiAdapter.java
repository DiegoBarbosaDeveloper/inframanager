package com.diegodev.inframanager.server.infrastructure.adapter.in.api;


import com.diegodev.inframanager.common.exception.ApiResponse;
import com.diegodev.inframanager.server.domain.port.in.ServerUseCase;
import com.diegodev.inframanager.server.infrastructure.adapter.in.api.dto.ServerRequest;
import com.diegodev.inframanager.server.infrastructure.adapter.in.api.mapper.ServerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerRestApiAdapter implements ServerRestApi {

    private final ServerUseCase serverUseCase;
    private final ServerMapper serverMapper;

    @GetMapping
    @Override
    public ResponseEntity<?> getAll(Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.success(serverUseCase.searchAll(pageable)));
    }

    @GetMapping("/search/system")
    @Override
    public ResponseEntity<?> getBySystem(@RequestParam String os, Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.success(serverUseCase.searchServerByOs(os, pageable)));
    }

    @GetMapping("/search/memory")
    @Override
    public ResponseEntity<?> getByRam(long ram, Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.success(serverUseCase.searchServerByRam(ram, pageable)));
    }

    @GetMapping("/search/processor")
    @Override
    public ResponseEntity<?> getByCpu(@RequestParam String cpu, Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.success(serverUseCase.searchByCpu(cpu, pageable)));
    }

    @GetMapping("/search/{status}")
    @Override
    public ResponseEntity<?> getByStatus(@PathVariable String status, Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.success(serverUseCase.searchServerByStatus(status, pageable)));
    }

    @GetMapping("/search/place")
    @Override
    public ResponseEntity<?> getByLocation(@RequestParam String location, Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.success(serverUseCase.searchByLocation(location, pageable)));
    }

    @PostMapping
    @Override
    public ResponseEntity<?> postServer(ServerRequest request) {
        return ResponseEntity.ok(ApiResponse.success(
                serverMapper.toResponseFromDomain(
                        serverUseCase.registerServer(
                                serverMapper.toDomainFromRequest(request)
                        )
                )
        ));
    }

    @PutMapping("/ip/{ip}")
    @Override
    public ResponseEntity<?> putByIp(@PathVariable String ip, @RequestBody ServerRequest request) {
        return ResponseEntity.ok(
                ApiResponse.success(
                        serverMapper.toResponseFromDomain(
                                serverUseCase.modifyServerByIp(
                                        ip,
                                        serverMapper.toDomainFromRequest(request)
                                )
                        )
                )
        );
    }

    @PutMapping
    @Override
    public ResponseEntity<?> putById(@RequestParam Long id, @RequestBody ServerRequest request) {
        return ResponseEntity.ok(
                ApiResponse.success(
                        serverMapper.toResponseFromDomain(
                                serverUseCase.modifyServerById(
                                        id,
                                        serverMapper.toDomainFromRequest(request)
                                )
                        )
                )
        );
    }
}
