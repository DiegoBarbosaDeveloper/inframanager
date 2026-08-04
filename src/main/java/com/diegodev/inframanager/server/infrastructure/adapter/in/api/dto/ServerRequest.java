package com.diegodev.inframanager.server.infrastructure.adapter.in.api.dto;


import com.diegodev.inframanager.server.infrastructure.adapter.in.api.AdapterOperativeSystem;
import com.diegodev.inframanager.server.infrastructure.adapter.in.api.AdapterServerStatus;

public record ServerRequest(
        String hostname,
        String ip,
        AdapterOperativeSystem os,
        Integer ram,
        String cpu,
        Long rom,
        AdapterServerStatus status,
        String location,
        String cloudProvider
) {}
