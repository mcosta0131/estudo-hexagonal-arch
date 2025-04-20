package com.estudohexagonalarch.application.service;

import com.estudohexagonalarch.application.inbound.DuplicataUseCase;
import com.estudohexagonalarch.application.outbound.DuplicataOutputPort;
import com.estudohexagonalarch.domain.DuplicataDomain;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DuplicataService implements DuplicataUseCase {

    private final DuplicataOutputPort duplicataOutPutPort;

    public DuplicataService(@Qualifier("client") DuplicataOutputPort duplicataOutPutPort) {
        this.duplicataOutPutPort = duplicataOutPutPort;
    }

    @Override
    public DuplicataDomain emiteDuplicata(DuplicataDomain duplicata) {
        duplicataOutPutPort.enviaDuplicata(duplicata);
        return duplicata;
    }
}

