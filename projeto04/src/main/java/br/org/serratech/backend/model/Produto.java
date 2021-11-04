package br.org.serratech.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;

    @NotBlank(message = "A descrição não pode ser nula")
    @Size(max = 60, message = "O tamanho do campo descrição não pode ser superior a 60 caracteres")
    @Column(name = "descricao", length = 60, nullable = false)
    private String descricao;

    @DecimalMax(value = "6000", message = "O preço não pode ser superior a R${value}.00")
    @DecimalMin(value = "100", message = "O preço não pode ser inferior a R${value}.00")
    @Column(name = "valor")
    private BigDecimal valor;

    @Future(message = "Data inválida")
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @Override
    public String toString() {
        return "Produto { id=" + getId() + ", descricao=" + getDescricao() + ", valor=" + getValor() + ", dataCadastro="
                + getDataCadastro() + "}";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
