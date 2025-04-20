package com.estudohexagonalarch.infrastructure.adapter.inbound.controller;

import com.estudohexagonalarch.application.inbound.DuplicataUseCase;
import com.estudohexagonalarch.domain.DuplicataDomain;
import com.estudohexagonalarch.infrastructure.adapter.inbound.dto.mapper.DuplicataDTOMapper;
import com.estudohexagonalarch.infrastructure.adapter.inbound.dto.request.DuplicataRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/duplicatas")
@RequiredArgsConstructor
public class DuplicataController {

    private final DuplicataUseCase duplicataUseCase;


    /**
     * Cria uma nova requestDTO.
     *
     * @param requestDTO objeto do tipo Duplicata recebido via request
     * @return objeto Duplicata criado encapsulado em ResponseEntity
     */
    @PostMapping
    public ResponseEntity<Object> criarDuplicata(@RequestBody DuplicataRequestDTO requestDTO) {
        DuplicataDomain duplicataCriada = duplicataUseCase.
                emiteDuplicata(DuplicataDTOMapper.toDomain(requestDTO));
        return ResponseEntity.ok(duplicataCriada);
    }
}
