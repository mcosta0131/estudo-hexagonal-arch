package com.estudohexagonalarch.infrastructure.adapter.inbound.event;

import com.estudohexagonalarch.application.service.DuplicataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DuplicataListener {

    private final DuplicataService duplicataService;


}
