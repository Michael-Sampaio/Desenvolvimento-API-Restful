package br.org.serratec.backend.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Caracteristica {
    private String renavam;
    private String chassi;
    private Long ano;
    private String cor;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @Enumerated(EnumType.ORDINAL)
    private Combustivel combustivel;

    public String getRenavam() {
        return this.renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getChassi() {
        return this.chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Long getAno() {
        return this.ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Combustivel getCombustivel() {
        return this.combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

}
