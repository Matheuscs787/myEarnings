package br.com.earnings.service.movimentacao;

import br.com.earnings.model.Movimentacao;

import java.util.List;
import java.util.Optional;

public interface MovimentacaoService {

    Movimentacao save(Movimentacao movimentacao);
    Movimentacao update(Movimentacao movimentacao);
    Optional<Movimentacao> findById(Long id);
    List<Movimentacao> findAll();
    List<Movimentacao> findAllByAtivoId(Long idAtivo);
    void deleteById(Long id);

}
