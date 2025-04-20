package com.estudohexagonalarch.application.service;

import com.estudohexagonalarch.application.inbound.DuplicataUseCase;
import com.estudohexagonalarch.application.outbound.DuplicataOutputPort;
import com.estudohexagonalarch.domain.DuplicataDomain;

public class DuplicataService implements DuplicataUseCase {

    private final DuplicataOutputPort duplicataOutPutPort;

    public DuplicataService(DuplicataOutputPort duplicataOutPutPort) {
        this.duplicataOutPutPort = duplicataOutPutPort;
    }

    @Override
    public DuplicataDomain emiteDuplicata(DuplicataDomain duplicata) {
        duplicataOutPutPort.enviaDuplicata(duplicata);
        return duplicata;
    }
}

