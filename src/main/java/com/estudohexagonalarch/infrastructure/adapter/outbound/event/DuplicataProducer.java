package com.estudohexagonalarch.infrastructure.adapter.outbound.event;

import com.estudohexagonalarch.application.outbound.DuplicataOutputPort;
import com.estudohexagonalarch.domain.DuplicataDomain;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("event")
public class DuplicataProducer
        implements DuplicataOutputPort {

    @Override
    public void enviaDuplicata(DuplicataDomain domain) {
        System.out.println("Enviado duplicata via mensagem");

    }
}
