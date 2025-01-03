package br.com.earnings.service.movimentacao;

import br.com.earnings.exceptions.NotFoundException;
import br.com.earnings.model.Movimentacao;
import br.com.earnings.repository.MovimentacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;

    public MovimentacaoServiceImpl(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    @Override
    public Movimentacao save(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    @Override
    public Movimentacao update(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    @Override
    public Optional<Movimentacao> findById(Long id) {
        Optional<Movimentacao> movimentacao = movimentacaoRepository.findById(id);
        if (movimentacao.isPresent()) {
            return movimentacao;
        }
        throw new NotFoundException("Movimentação não encontrada");
    }

    @Override
    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    @Override
    public List<Movimentacao> findAllByAtivoId(Long idAtivo) {
        return movimentacaoRepository.findAllByAtivo_Id(idAtivo);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Movimentacao> movimentacao = movimentacaoRepository.findById(id);
        if (movimentacao.isPresent()) {
            movimentacaoRepository.deleteById(id);
        }else{
            throw new NotFoundException("Movimentação não encontrada");
        }
    }
}
