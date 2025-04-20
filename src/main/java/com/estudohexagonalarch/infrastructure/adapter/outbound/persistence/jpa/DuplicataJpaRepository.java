package com.estudohexagonalarch.infrastructure.adapter.outbound.persistence.jpa;

import com.estudohexagonalarch.infrastructure.adapter.outbound.persistence.entity.DuplicataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuplicataJpaRepository extends JpaRepository<DuplicataEntity, String> {

}
