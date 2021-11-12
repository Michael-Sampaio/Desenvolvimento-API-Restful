package br.org.serratec.backend.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Long id;

    @Column(name = "data_consulta")
    private LocalDate dataConsulta;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @JsonManagedReference
    @OneToMany(mappedBy = "consulta")
    private List<Procedimento> procedimentos;

    @Transient
    private Double totalGeral;

    public Long getConsulta() {
        return this.id;
    }

    public void setConsulta(Long id) {
        this.id = id;
    }

    public LocalDate getDataConsulta() {
        return this.dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Procedimento> getProcedimentos() {
        return this.procedimentos;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProcedimentos(List<Procedimento> procedimentos) {
        this.procedimentos = procedimentos;
    }

    public Double getTotalGeral() {
        totalGeral = 0.0;
        for (Procedimento procedimento : procedimentos) {
            totalGeral += procedimento.getSubtotal();
        }
        return totalGeral;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Consulta)) {
            return false;
        }
        Consulta consulta = (Consulta) o;
        return Objects.equals(id, consulta.id);
    }

}