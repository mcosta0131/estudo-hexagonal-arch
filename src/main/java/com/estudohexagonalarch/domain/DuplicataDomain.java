package com.estudohexagonalarch.domain;

import java.math.BigDecimal;

public class DuplicataDomain {

    private String nomeSacador;
    private BigDecimal valorDuplicata;

    public DuplicataDomain() {}

    private DuplicataDomain(Builder builder) {
        this.nomeSacador = builder.nomeSacador;
        this.valorDuplicata = builder.valorDuplicata;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String nomeSacador;
        private BigDecimal valorDuplicata;

        public Builder nomeSacador(String nomeSacador) {
            this.nomeSacador = nomeSacador;
            return this;
        }

        public Builder valorDuplicata(BigDecimal valorDuplicata) {
            this.valorDuplicata = valorDuplicata;
            return this;
        }

        public DuplicataDomain build() {
            return new DuplicataDomain(this);
        }
    }

    public String getNomeSacador() {
        return nomeSacador;
    }

    public void setNomeSacador(String nomeSacador) {
        this.nomeSacador = nomeSacador;
    }

    public BigDecimal getValorDuplicata() {
        return valorDuplicata;
    }

    public void setValorDuplicata(BigDecimal valorDuplicata) {
        this.valorDuplicata = valorDuplicata;
    }
}
