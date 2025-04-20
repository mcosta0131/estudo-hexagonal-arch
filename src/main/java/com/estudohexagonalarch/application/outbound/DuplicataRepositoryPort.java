package com.estudohexagonalarch.application.outbound;

import com.estudohexagonalarch.domain.DuplicataDomain;

import java.util.Optional;

public interface DuplicataRepositoryPort {

    void salvar(DuplicataDomain duplicata);

    Optional<DuplicataDomain> buscarPorId(String id);
}
