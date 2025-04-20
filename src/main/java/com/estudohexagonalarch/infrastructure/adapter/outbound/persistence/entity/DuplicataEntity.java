package com.estudohexagonalarch.infrastructure.adapter.outbound.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "duplicata")
@Getter
@Setter
public class DuplicataEntity {
    @Id
    private String id;
    private String nomeSacador;
    private BigDecimal valorDuplicata;

}
