package br.org.serratech.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratech.backend.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
