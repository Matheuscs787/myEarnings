package br.com.earnings.controller;

import br.com.earnings.model.Movimentacao;
import br.com.earnings.service.movimentacao.MovimentacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/movimentacao")
@Tag(name = "Movimentação", description = "Endpoints utilizados para o CRUD de movimentações")
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;

    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @GetMapping
    @Operation(description = "Buscar todas as movimentações")
    public ResponseEntity<List<Movimentacao>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(movimentacaoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(description = "Busca uma movimentação pelo id")
    public ResponseEntity<Optional<Movimentacao>> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(movimentacaoService.findById(id));
    }

    @GetMapping("/ativo/{id}")
    @Operation(description = "Busca todas as movimentações pelo id do ativo")
    public ResponseEntity<List<Movimentacao>> findAllByAtivoId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(movimentacaoService.findAllByAtivoId(id));
    }

    @PostMapping
    @Operation(description = "Salvar movimentação")
    public ResponseEntity<Movimentacao> save(@RequestBody Movimentacao movimentacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoService.save(movimentacao));
    }

    @PutMapping
    @Operation(description = "Atualiza movimentação")
    public ResponseEntity<Movimentacao> update(@RequestBody Movimentacao movimentacao) {
        return ResponseEntity.status(HttpStatus.OK).body(movimentacaoService.update(movimentacao));
    }

    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        movimentacaoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
