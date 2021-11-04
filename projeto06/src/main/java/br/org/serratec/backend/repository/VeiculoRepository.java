package br.org.serratec.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.backend.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
