package br.org.serratec.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.backend.model.Exame;

public interface ExameRepository extends JpaRepository<Exame, Long> {
    
}
