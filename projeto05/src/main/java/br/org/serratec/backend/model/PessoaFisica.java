package br.org.serratec.backend.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Fornecedor {

    @Column
    private String cpf;
    @Column
    private String rg;
    @Column
    private String orgaoEmissor;
    @Column
    private LocalDate dataExpedicao;

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgaoEmissor() {
        return this.orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public LocalDate getDataExpedicao() {
        return this.dataExpedicao;
    }

    public void setDataExpedicao(LocalDate dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

}
