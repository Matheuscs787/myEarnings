package br.com.earnings.controller;

import br.com.earnings.model.Categoria;
import br.com.earnings.service.categoria.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/categoria")
@Tag(name = "Categoria", description = "Endpoints utilizados para o CRUD de categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    @Operation(description = "Buscar todas as categorias")
    public ResponseEntity<List<Categoria>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(description = "Buscar categoria por id")
    public ResponseEntity<Optional<Categoria>> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findById(id));
    }

    @PostMapping()
    @Operation(description = "Salvar categoria")
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }

    @PutMapping
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.update(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        categoriaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}