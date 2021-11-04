package br.org.serratec.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.backend.model.Manutencao;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {

}
