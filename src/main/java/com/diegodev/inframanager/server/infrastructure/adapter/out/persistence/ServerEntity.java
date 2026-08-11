package com.diegodev.inframanager.server.infrastructure.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "servers")
public class ServerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String hostname;

    @Column(nullable = false, unique = true)
    private String ip;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PersistenceOperativeSystem os;

    @Column(nullable = false)
    private Long ram;

    @Column(nullable = false)
    private String cpu;

    @Column(nullable = false)
    private Long rom;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PersistenceServerStatus status;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String cloudProvider;


}
