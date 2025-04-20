package com.estudohexagonalarch.infrastructure.adapter.inbound.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DuplicataRequestDTO {

    private String nomeSacador;
    private BigDecimal valorDuplicata;
    private String nomeSacado;
}
