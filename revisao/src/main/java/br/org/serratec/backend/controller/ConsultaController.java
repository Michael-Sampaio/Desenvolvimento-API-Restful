package br.org.serratec.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.backend.dto.ConsultaDTO;
import br.org.serratec.backend.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    
    @Autowired
    ConsultaService consultaService;

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> buscar(@PathVariable Long id){
        return ResponseEntity.ok(consultaService.buscar(id));
    }

    @GetMapping
    public ResponseEntity<List<ConsultaDTO>> listar(){
        return ResponseEntity.ok(consultaService.listar());
    }

}
