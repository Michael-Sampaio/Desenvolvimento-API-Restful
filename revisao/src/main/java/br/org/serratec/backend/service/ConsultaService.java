package br.org.serratec.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.backend.dto.ConsultaDTO;
import br.org.serratec.backend.model.Consulta;
import br.org.serratec.backend.repository.ConsultaRepository;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public ConsultaDTO buscar(Long id) {
        Optional<Consulta> consulta = consultaRepository.findById(id);
        return new ConsultaDTO(consulta.get());
    }

    public List<ConsultaDTO> listar() {
        List<Consulta> consultas = consultaRepository.findAll();
        return consultas.stream().map(consulta -> new ConsultaDTO(consulta)).collect(Collectors.toList());
    }
}
