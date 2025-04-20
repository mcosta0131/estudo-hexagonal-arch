package com.estudohexagonalarch.infrastructure.adapter.inbound.controller;

import com.estudohexagonalarch.application.inbound.DuplicataUseCase;
import com.estudohexagonalarch.domain.DuplicataDomain;
import com.estudohexagonalarch.infrastructure.adapter.inbound.dto.mapper.DuplicataDTOMapper;
import com.estudohexagonalarch.infrastructure.adapter.inbound.dto.request.DuplicataRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

class DuplicataControllerUnitTest {

    private final DuplicataUseCase useCase = mock(DuplicataUseCase.class);
    private final DuplicataController controller = new DuplicataController(useCase);
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    private DuplicataRequestDTO carregarJsonComoDTO(String nomeArquivo) throws Exception {
        String json = Files.readString(Path.of("src/test/resources/payloads/", nomeArquivo));
        return objectMapper.readValue(json, DuplicataRequestDTO.class);
    }

    @Test
    @DisplayName("Deve criar duplicata e garantir que os dados corretos foram enviados ao caso de uso")
    void deveCriarDuplicataRetornandoObjetoDomain() throws Exception {
        // Given
        DuplicataRequestDTO dto = carregarJsonComoDTO("duplicata_valida.json");

        DuplicataDomain duplicataMock = DuplicataDTOMapper.toDomain(dto);
        when(useCase.emiteDuplicata(argThat(domain ->
                domain != null &&
                        dto.getNomeSacador().equals(domain.getNomeSacador()) &&
                        dto.getValorDuplicata().compareTo(domain.getValorDuplicata()) == 0
        ))).thenReturn(duplicataMock);

        // When
        var response = controller.criarDuplicata(dto);

        // Then
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(duplicataMock, response.getBody());

        // Captura o argumento para inspecionar o objeto realmente enviado
        ArgumentCaptor<DuplicataDomain> captor = ArgumentCaptor.forClass(DuplicataDomain.class);
        verify(useCase).emiteDuplicata(captor.capture());

        DuplicataDomain enviado = captor.getValue();
        assertEquals(dto.getNomeSacador(), enviado.getNomeSacador());
        assertEquals(0, dto.getValorDuplicata().compareTo(enviado.getValorDuplicata()));
    }
}
