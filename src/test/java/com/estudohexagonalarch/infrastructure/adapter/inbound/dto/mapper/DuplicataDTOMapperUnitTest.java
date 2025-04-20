package com.estudohexagonalarch.infrastructure.adapter.inbound.dto.mapper;

import com.estudohexagonalarch.domain.DuplicataDomain;
import com.estudohexagonalarch.infrastructure.adapter.inbound.dto.request.DuplicataRequestDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DuplicataDTOMapperUnitTest {

    @Test
    @DisplayName("Deve mapear corretamente de DuplicataRequestDTO para DuplicataDomain")
    void deveMapearDeDtoParaDomain() {
        // Arrange
        DuplicataRequestDTO dto = DuplicataRequestDTO.builder()
                .nomeSacador("Empresa XPTO")
                .valorDuplicata(new BigDecimal("999.99"))
                .build();

        // Act
        DuplicataDomain domain = DuplicataDTOMapper.toDomain(dto);

        // Assert
        assertNotNull(domain);
        assertEquals(dto.getNomeSacador(), domain.getNomeSacador());
        assertEquals(dto.getValorDuplicata(), domain.getValorDuplicata());
    }

    @Test
    @DisplayName("Deve mapear corretamente de DuplicataDomain para DuplicataRequestDTO")
    void deveMapearDeDomainParaDto() {
        // Arrange
        DuplicataDomain domain = DuplicataDomain.builder()
                .nomeSacador("Cliente ABC")
                .valorDuplicata(new BigDecimal("123.45"))
                .build();

        // Act
        DuplicataRequestDTO dto = DuplicataDTOMapper.toResponse(domain);

        // Assert
        assertNotNull(dto);
        assertEquals(domain.getNomeSacador(), dto.getNomeSacador());
        assertEquals(domain.getValorDuplicata(), dto.getValorDuplicata());
    }
}
