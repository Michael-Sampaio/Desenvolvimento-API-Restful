package br.org.serratec.backend.dto;

import br.org.serratec.backend.model.Procedimento;

public class ProcedimentoDTO {
    private String tipo;
    private Integer quantidade;
    private Double valorProcedimento;
    private Double subTotal;

    public ProcedimentoDTO() {
    }

    public ProcedimentoDTO(Procedimento procedimento) {
        this.tipo = procedimento.getExame().getTipo();
        this.quantidade = procedimento.getQuantidade();
        this.valorProcedimento = procedimento.getValorProcedimento();
        this.subTotal = procedimento.getSubtotal();
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorProcedimento() {
        return this.valorProcedimento;
    }

    public void setValorProcedimento(Double valorProcedimento) {
        this.valorProcedimento = valorProcedimento;
    }

    public Double getSubTotal() {
        return this.subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

}
