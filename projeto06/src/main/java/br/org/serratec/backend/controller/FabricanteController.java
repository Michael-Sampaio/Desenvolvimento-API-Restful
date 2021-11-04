package br.org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.backend.model.Fabricante;
import br.org.serratec.backend.repository.FabricanteRepository;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @GetMapping
    public List<Fabricante> listar() {
        return fabricanteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fabricante> buscar(@PathVariable Long id) {
        Optional<Fabricante> fabricante = fabricanteRepository.findById(id);
        if (!fabricante.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fabricante.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fabricante inserir(@Valid @RequestBody Fabricante fabricante) {
        return fabricanteRepository.save(fabricante);
    }

}
