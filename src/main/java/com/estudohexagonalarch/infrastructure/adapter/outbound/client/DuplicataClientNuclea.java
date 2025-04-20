package com.estudohexagonalarch.infrastructure.adapter.outbound.client;

import com.estudohexagonalarch.application.outbound.DuplicataOutputPort;
import com.estudohexagonalarch.domain.DuplicataDomain;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("client")
public class DuplicataClientNuclea implements DuplicataOutputPort {

    @Override
    public void enviaDuplicata(DuplicataDomain domain) {
        System.out.println("Enviando duplicata via client");
    }
}
