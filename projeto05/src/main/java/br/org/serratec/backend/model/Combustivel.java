package br.org.serratec.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.org.serratec.backend.exception.EnumValidationException;

public enum Combustivel {
    ALCOOL(1, "Álcool"), GASOLINA(2, "Gasolina"), DIESEL(3, "Diesel"), FLEX(4, "Flex"), GNV(5, "GNV");

    private Integer codigo;
    private String descricao;

    private Combustivel(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }
    
    @JsonCreator
    public static Combustivel verifica(Integer valor) throws EnumValidationException {
        for (Combustivel combustivel : Combustivel.values()) {
            if(valor.equals(combustivel.getCodigo())){
                return combustivel;
            }
        }
        throw new EnumValidationException("Combustível inválido");
    }
}
