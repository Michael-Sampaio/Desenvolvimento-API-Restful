package br.org.serratec.backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.backend.model.Proprietario;
import br.org.serratec.backend.repository.ProprietarioRepository;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Proprietario inserir(@Valid @RequestBody Proprietario proprietario) {
        return proprietarioRepository.save(proprietario);
    }

    @PostMapping("/varios")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Proprietario> inserirVarios(@Valid @RequestBody List<Proprietario> proprietarios) {
        return proprietarioRepository.saveAll(proprietarios);
    }

    @GetMapping
    public List<Proprietario> listar() {
        return proprietarioRepository.findAll();
    }
}
