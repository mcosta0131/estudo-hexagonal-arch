package com.estudohexagonalarch.infrastructure.adapter.outbound.persistence.mapper;

import com.estudohexagonalarch.domain.DuplicataDomain;
import com.estudohexagonalarch.infrastructure.adapter.outbound.persistence.entity.DuplicataEntity;

import java.util.UUID;

public class DuplicataPersistenceMapper {
    public static DuplicataEntity toEntity(DuplicataDomain domain) {
        DuplicataEntity entity = new DuplicataEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setNomeSacador(domain.getNomeSacador());
        entity.setValorDuplicata(domain.getValorDuplicata());
        return entity;
    }

    public static DuplicataDomain toDomain(DuplicataEntity e) {
        DuplicataDomain domain = new DuplicataDomain();
        domain.setNomeSacador(e.getNomeSacador());
        domain.setValorDuplicata(e.getValorDuplicata());
        return domain;
    }
}
