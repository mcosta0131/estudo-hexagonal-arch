package com.estudohexagonalarch.application.service;

import com.estudohexagonalarch.application.inbound.DuplicataUseCase;
import com.estudohexagonalarch.application.outbound.DuplicataOutputPort;
import com.estudohexagonalarch.application.outbound.DuplicataRepositoryPort;
import com.estudohexagonalarch.domain.DuplicataDomain;

public class DuplicataService implements DuplicataUseCase {

    private final DuplicataOutputPort duplicataOutPutPort;
    private final DuplicataRepositoryPort duplicataRepositoryPort;

    public DuplicataService(DuplicataOutputPort duplicataOutPutPort, DuplicataRepositoryPort duplicataRepositoryPort) {
        this.duplicataOutPutPort = duplicataOutPutPort;
        this.duplicataRepositoryPort = duplicataRepositoryPort;
    }


    @Override
    public DuplicataDomain emiteDuplicata(DuplicataDomain duplicata) {
        duplicataOutPutPort.enviaDuplicata(duplicata);
        duplicataRepositoryPort.salvar(duplicata);
        return duplicata;
    }
}

