package com.estudohexagonalarch.infrastructure.config;

import com.estudohexagonalarch.application.inbound.DuplicataUseCase;
import com.estudohexagonalarch.application.outbound.DuplicataRepositoryPort;
import com.estudohexagonalarch.application.service.DuplicataService;
import com.estudohexagonalarch.application.outbound.DuplicataOutputPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public DuplicataUseCase duplicataUseCase(
            @Qualifier("client") DuplicataOutputPort duplicataOutputPort,
            DuplicataRepositoryPort duplicataRepositoryPort
    ) {
        return new DuplicataService(duplicataOutputPort, duplicataRepositoryPort);
    }
}


