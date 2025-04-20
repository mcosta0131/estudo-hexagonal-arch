package com.estudohexagonalarch.infrastructure.adapter.outbound.persistence;

import com.estudohexagonalarch.application.outbound.DuplicataRepositoryPort;
import com.estudohexagonalarch.domain.DuplicataDomain;
import com.estudohexagonalarch.infrastructure.adapter.outbound.persistence.jpa.DuplicataJpaRepository;
import com.estudohexagonalarch.infrastructure.adapter.outbound.persistence.mapper.DuplicataPersistenceMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DuplicataRepositoryAdapter implements DuplicataRepositoryPort {

    private final DuplicataJpaRepository jpa;

    public DuplicataRepositoryAdapter(DuplicataJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public void salvar(DuplicataDomain domain) {
        jpa.save(DuplicataPersistenceMapper.toEntity(domain));
    }

    @Override
    public Optional<DuplicataDomain> buscarPorId(String id) {
        return Optional.empty();
    }
}
