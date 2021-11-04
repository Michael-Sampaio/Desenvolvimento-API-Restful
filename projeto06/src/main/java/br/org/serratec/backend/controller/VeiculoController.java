package br.org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.org.serratec.backend.model.Veiculo;
import br.org.serratec.backend.repository.VeiculoRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    @ApiOperation(value = "Listar todos os veículos", notes = "Listagem de veículos")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna todos os veículos"),
        @ApiResponse(code = 401, message = "Erro de autenticação"),
        @ApiResponse(code = 403, message = "Recurso proibido"),
        @ApiResponse(code = 404, message = "Recurso não encontrado"),
        @ApiResponse(code = 500, message = "Erro do servidor")
    })
    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    @ApiOperation(value = "Buscar um veículo", notes = "Busca de veículos")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Veículo encontrado"),
        @ApiResponse(code = 401, message = "Erro de autenticação"),
        @ApiResponse(code = 403, message = "Recurso proibido"),
        @ApiResponse(code = 404, message = "Recurso não encontrado"),
        @ApiResponse(code = 500, message = "Erro do servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscar(@PathVariable Long id) {
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        if (!veiculo.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(veiculo.get());
    }

    @ApiOperation(value = "Cadastrar um veículo", notes = "Cadastro de veículos")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Cadastra veículo"),
        @ApiResponse(code = 401, message = "Erro de autenticação"),
        @ApiResponse(code = 403, message = "Recurso proibido"),
        @ApiResponse(code = 404, message = "Recurso não encontrado"),
        @ApiResponse(code = 500, message = "Erro do servidor")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo inserir(@Valid @RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> alterar(@PathVariable Long id, @Valid @RequestBody Veiculo veiculo) {
        if (!veiculoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        veiculo.setId(id);
        veiculo = veiculoRepository.save(veiculo);
        return ResponseEntity.ok(veiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Veiculo> excluir(@PathVariable Long id) {
        if (!veiculoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        veiculoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
