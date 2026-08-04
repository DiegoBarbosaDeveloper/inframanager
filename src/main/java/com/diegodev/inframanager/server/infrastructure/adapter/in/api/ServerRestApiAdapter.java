package com.diegodev.inframanager.server.infrastructure.adapter.in.api;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerRestApiAdapter implements ServerRestApi {


    @Override
    public ResponseEntity<?> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> getBySystem(String operativeSystem) {
        return null;
    }

    @Override
    public ResponseEntity<?> getByRam(long ram) {
        return null;
    }

    @Override
    public ResponseEntity<?> getByCpu(String cpu) {
        return null;
    }

    @Override
    public ResponseEntity<?> getByStatus(String os) {
        return null;
    }

    @Override
    public ResponseEntity<?> getByLocation(String location) {
        return null;
    }
}
