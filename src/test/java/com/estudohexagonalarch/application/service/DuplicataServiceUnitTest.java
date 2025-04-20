package com.estudohexagonalarch.application.service;

import com.estudohexagonalarch.application.outbound.DuplicataOutputPort;
import com.estudohexagonalarch.application.outbound.DuplicataRepositoryPort;
import com.estudohexagonalarch.domain.DuplicataDomain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DuplicataServiceUnitTest {

    private final DuplicataOutputPort outputPort = mock(DuplicataOutputPort.class);
    private final DuplicataRepositoryPort repositoryPort = mock(DuplicataRepositoryPort.class);
    private final DuplicataService service = new DuplicataService(outputPort, repositoryPort);

    @Test
    @DisplayName("Deve emitir duplicata e garantir que ambas as portas foram chamadas com os dados corretos")
    void deveEmitirEDepositarDuplicataCorretamente() {
        // Arrange
        DuplicataDomain duplicata = new DuplicataDomain();
        duplicata.setNomeSacador("Cliente XPTO");
        duplicata.setValorDuplicata(new BigDecimal("1500.00"));

        // Act
        DuplicataDomain resultado = service.emiteDuplicata(duplicata);

        // Assert
        // Verifica retorno
        assertEquals(duplicata, resultado);

        // Captura argumentos enviados às portas
        ArgumentCaptor<DuplicataDomain> outputCaptor = ArgumentCaptor.forClass(DuplicataDomain.class);
        ArgumentCaptor<DuplicataDomain> repositoryCaptor = ArgumentCaptor.forClass(DuplicataDomain.class);

        verify(outputPort, times(1)).enviaDuplicata(outputCaptor.capture());
        verify(repositoryPort, times(1)).salvar(repositoryCaptor.capture());

        DuplicataDomain enviadoParaOutput = outputCaptor.getValue();
        DuplicataDomain enviadoParaRepo = repositoryCaptor.getValue();

        // Verifica se os dados enviados às portas são os esperados
        assertEquals(duplicata.getNomeSacador(), enviadoParaOutput.getNomeSacador());
        assertEquals(duplicata.getValorDuplicata(), enviadoParaOutput.getValorDuplicata());

        assertEquals(duplicata.getNomeSacador(), enviadoParaRepo.getNomeSacador());
        assertEquals(duplicata.getValorDuplicata(), enviadoParaRepo.getValorDuplicata());
    }
}
