package com.estudohexagonalarch.application.outbound;

import com.estudohexagonalarch.domain.DuplicataDomain;

public interface DuplicataOutputPort {

    void enviaDuplicata(DuplicataDomain domain);

}
