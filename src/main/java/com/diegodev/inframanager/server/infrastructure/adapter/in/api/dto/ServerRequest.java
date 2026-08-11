package com.diegodev.inframanager.server.infrastructure.adapter.in.api.dto;


import com.diegodev.inframanager.server.infrastructure.adapter.in.api.AdapterOperativeSystem;
import com.diegodev.inframanager.server.infrastructure.adapter.in.api.AdapterServerStatus;
import jakarta.validation.constraints.NotBlank;

public record ServerRequest(
        @NotBlank String hostname,
        @NotBlank String ip,
        AdapterOperativeSystem os,
        Integer ram,
        @NotBlank String cpu,
        Long rom,
        AdapterServerStatus status,
        @NotBlank String location,
        @NotBlank String cloudProvider
) {}
