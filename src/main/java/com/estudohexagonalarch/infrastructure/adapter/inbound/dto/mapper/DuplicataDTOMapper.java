package com.estudohexagonalarch.infrastructure.adapter.inbound.dto.mapper;

import com.estudohexagonalarch.domain.DuplicataDomain;
import com.estudohexagonalarch.infrastructure.adapter.inbound.dto.request.DuplicataRequestDTO;

public class DuplicataDTOMapper {

    public static DuplicataDomain toDomain(DuplicataRequestDTO dto) {
        return DuplicataDomain.builder()
                .nomeSacador(dto.getNomeSacador())
                .valorDuplicata(dto.getValorDuplicata())
                .build();
    }

    public static DuplicataRequestDTO toResponse(DuplicataDomain domain) {
        return DuplicataRequestDTO.builder()
                .nomeSacador(domain.getNomeSacador())
                .valorDuplicata(domain.getValorDuplicata())
                .build();
    }

}
