package br.org.serratec.backend.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "procedimentos")
public class Procedimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_procedimento")
    private Long id;

    private Integer quantidade;

    @Column(name = "valor_procedimento")
    private Double valorProcedimento;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_consulta")
    private Consulta consulta;

    @ManyToOne
    @JoinColumn(name = "id_exame")
    private Exame exame;

    @Transient
    private Double subtotal;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Consulta getConsulta() {
        return this.consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Exame getExame() {
        return this.exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public Double getSubtotal() {
        subtotal = quantidade * valorProcedimento;
        return subtotal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Procedimento)) {
            return false;
        }
        Procedimento procedimento = (Procedimento) o;
        return Objects.equals(id, procedimento.id);
    }

}
