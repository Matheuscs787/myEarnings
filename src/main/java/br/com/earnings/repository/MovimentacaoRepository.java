package br.com.earnings.repository;

import br.com.earnings.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

    Movimentacao save(Movimentacao movimentacao);
    Optional<Movimentacao> findById(Long id);
    List<Movimentacao> findAll();
    List<Movimentacao> findAllByAtivo_Id(Long idAtivo);
    void deleteById(Long id);

}
