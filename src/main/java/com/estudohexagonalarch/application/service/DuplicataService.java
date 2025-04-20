package com.estudohexagonalarch.application.service;

import com.estudohexagonalarch.application.inbound.DuplicataUseCase;
import com.estudohexagonalarch.application.outbound.DuplicataOutPutPort;
import com.estudohexagonalarch.domain.DuplicataDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DuplicataService implements DuplicataUseCase {

    private final DuplicataOutPutPort duplicataOutPutPort;

    public DuplicataService(@Qualifier("client") DuplicataOutPutPort duplicataOutPutPort) {
        this.duplicataOutPutPort = duplicataOutPutPort;
    }

    @Override
    public DuplicataDomain emiteDuplicata(DuplicataDomain duplicata) {
        duplicataOutPutPort.enviaDuplicata(duplicata);
        return duplicata;
    }
}

