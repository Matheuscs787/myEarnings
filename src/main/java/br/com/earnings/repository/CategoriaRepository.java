package br.com.earnings.repository;

import br.com.earnings.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Categoria findByNome(String nome);
    Categoria findBySigla(String sigla);
    Optional<Categoria> findById(Long id);
    Categoria save(Categoria categoria);
    void deleteById(Long id);
    List<Categoria> findAll();
}
