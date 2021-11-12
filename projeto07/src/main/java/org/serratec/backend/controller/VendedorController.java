package org.serratec.backend.controller;

import java.util.List;

import org.serratec.backend.model.Vendedor;
import org.serratec.backend.repository.VendedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

	@Autowired
	VendedorRepository vendedorRepository;

	@GetMapping
	public ResponseEntity<List<Vendedor>> listar() {
		return ResponseEntity.ok(vendedorRepository.findAll());
	}

	@GetMapping("/pagina")
	public ResponseEntity<Page<Vendedor>> listarPorPagina(@PageableDefault(sort  = {"nome", "dataNascimento"},  direction = Direction.ASC, size = 10, page = 0) Pageable pageable) {
		Page<Vendedor> vendedores = vendedorRepository.findAll(pageable);
		return ResponseEntity.ok(vendedores);
	}
	
	@GetMapping("/salario")
	public ResponseEntity<Page<Vendedor>> listarPorFaixaSalarial(@PageableDefault(page = 1) @RequestParam(defaultValue = "0") Double valorMinimo,
			@RequestParam(defaultValue = "10000") Double valorMaximo, Pageable pageable) {

		Page<Vendedor> vendedores = vendedorRepository.buscarFaixaSalario(valorMinimo, valorMaximo, pageable);
		return ResponseEntity.ok(vendedores);
	}
	
}
