package com.estudohexagonalarch.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DuplicataDomainUnitTest {

    @Test
    @DisplayName("Deve construir DuplicataDomain com builder corretamente")
    void deveConstruirComBuilder() {
        // Arrange
        String nome = "João da Silva";
        BigDecimal valor = new BigDecimal("1234.56");

        // Act
        DuplicataDomain duplicata = DuplicataDomain.builder()
                .nomeSacador(nome)
                .valorDuplicata(valor)
                .build();

        // Assert
        assertNotNull(duplicata);
        assertEquals(nome, duplicata.getNomeSacador());
        assertEquals(valor, duplicata.getValorDuplicata());
    }

    @Test
    @DisplayName("Deve permitir alteração dos campos com setters")
    void devePermitirAlteracaoComSetters() {
        // Arrange
        DuplicataDomain duplicata = new DuplicataDomain();
        String nome = "Maria Oliveira";
        BigDecimal valor = new BigDecimal("987.65");

        // Act
        duplicata.setNomeSacador(nome);
        duplicata.setValorDuplicata(valor);

        // Assert
        assertEquals(nome, duplicata.getNomeSacador());
        assertEquals(valor, duplicata.getValorDuplicata());
    }

    @Test
    @DisplayName("Deve permitir instanciar com construtor vazio")
    void deveInstanciarComConstrutorPadrao() {
        DuplicataDomain duplicata = new DuplicataDomain();
        assertNotNull(duplicata);
    }
}
