package com.diegodev.inframanager.server.domain.model;

import lombok.Data;

@Data
public class Server {
    private String hostname;
    private String ip;
    private OperativeSystem os;
    private Integer ram;
    private String cpu;
    private Long rom;
    private ServerStatus status;
    private String location;
    private String cloudProvider;
}
