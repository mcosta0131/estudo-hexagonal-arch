package com.estudohexagonalarch.application.inbound;

import com.estudohexagonalarch.domain.DuplicataDomain;

public interface DuplicataUseCase {

    DuplicataDomain emiteDuplicata(DuplicataDomain duplicata);
}
