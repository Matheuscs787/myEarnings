package br.com.earnings.service.categoria;

import br.com.earnings.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    Categoria save(Categoria categoria);
    Categoria update(Categoria categoria);
    void deleteById(Long id);
    Optional<Categoria> findById(Long id);
    List<Categoria> findAll();
}
