package com.estudohexagonalarch.application.outbound;

import com.estudohexagonalarch.domain.DuplicataDomain;

public interface DuplicataOutPutPort {

    void enviaDuplicata(DuplicataDomain domain);

}
