package br.com.earnings.service.categoria;

import br.com.earnings.exceptions.NotFoundException;
import br.com.earnings.model.Categoria;
import br.com.earnings.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    final CategoriaRepository categoriaRepository;
    private static final String CATEGORIA_NOT_FOUND = "Categoria não encontrada!";

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            categoriaRepository.deleteById(id);
        }else{
            throw new NotFoundException(CATEGORIA_NOT_FOUND);
        }
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent()) {
            return categoria;
        }
        throw new NotFoundException(CATEGORIA_NOT_FOUND);
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
}