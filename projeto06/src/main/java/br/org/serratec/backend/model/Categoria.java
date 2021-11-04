package br.org.serratec.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.org.serratec.backend.exception.EnumValidationException;

public enum Categoria {
    HATCH, SEDAN, PICAPE, SUV, CONVERSIVEL, MINIVAN;

    @JsonCreator
    public static Categoria verifica(String valor) throws EnumValidationException {
        for (Categoria categoria : values()) {
            if (valor.equals(categoria.name())) {
                return categoria;
            }
        }
        throw new EnumValidationException("Categoria inválida");
    }

}
