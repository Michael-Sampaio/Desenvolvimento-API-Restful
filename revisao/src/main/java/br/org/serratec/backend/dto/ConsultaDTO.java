package br.org.serratec.backend.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.org.serratec.backend.model.Consulta;

public class ConsultaDTO {
    private LocalDate dataConsulta;
    private String nomePaciente;
    private List<ProcedimentoDTO> procedimentosDTO;
    private Double totalGeral;

    public ConsultaDTO() {
    }

    public ConsultaDTO(Consulta consulta) {
        this.dataConsulta = consulta.getDataConsulta();
        this.nomePaciente = consulta.getPaciente().getNome();
        this.procedimentosDTO = consulta.getProcedimentos().stream().map(p -> new ProcedimentoDTO(p))
                .collect(Collectors.toList());
        this.totalGeral = consulta.getTotalGeral();
    }

    public LocalDate getDataConsulta() {
        return this.dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getNomePaciente() {
        return this.nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public List<ProcedimentoDTO> getProcedimentosDTO() {
        return this.procedimentosDTO;
    }

    public void setProcedimentosDTO(List<ProcedimentoDTO> procedimentosDTO) {
        this.procedimentosDTO = procedimentosDTO;
    }

    public Double getTotalGeral() {
        return this.totalGeral;
    }

    public void setTotalGeral(Double totalGeral) {
        this.totalGeral = totalGeral;
    }

}
