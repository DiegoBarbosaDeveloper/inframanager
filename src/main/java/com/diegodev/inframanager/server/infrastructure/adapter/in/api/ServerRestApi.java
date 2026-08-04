package com.diegodev.inframanager.server.infrastructure.adapter.in.api;

import org.springframework.http.ResponseEntity;

public interface ServerRestApi {

    ResponseEntity<?> getAll();

    ResponseEntity<?> getBySystem(String operativeSystem);

    ResponseEntity<?> getByRam(long ram);

    ResponseEntity<?> getByCpu(String cpu);

    ResponseEntity<?> getByStatus(String os);

    ResponseEntity<?> getByLocation(String location);

}
