package org.serratec.backend.repository;

import org.serratec.backend.model.Vendedor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VendedorRepository extends JpaRepository<Vendedor, Long>{

    @Query("SELECT v FROM Vendedor v WHERE v.salario>=:valorMinimo AND v.salario<=:valorMaximo")
    Page<Vendedor> buscarFaixaSalario(Double valorMinimo, Double valorMaximo, org.springframework.data.domain.Pageable pageable);
}
