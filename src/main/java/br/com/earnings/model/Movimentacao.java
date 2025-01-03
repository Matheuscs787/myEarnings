package br.com.earnings.model;

import br.com.earnings.model.enums.TipoMovimentacaoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_movimentacao")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_movimentacao")
    private Long id;
    private TipoMovimentacaoEnum tipoMovimentacao;
    private BigDecimal valorMovimentacao;
    @ManyToOne
    @JoinColumn(name = "cd_ativo")
    private Ativo ativo;
    private BigDecimal quantidade;
    private Date dataMovimentacao;
}
