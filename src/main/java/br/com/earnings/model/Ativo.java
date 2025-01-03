package br.com.earnings.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("movimentacoes")
@Table(name = "tb_ativo")
public class Ativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_ativo")
    private Long id;
    private String nome;
    private String sigla;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "cd_categoria")
    private Categoria categoria;
    @OneToMany(mappedBy = "ativo")
    private List<Movimentacao> movimentacoes;
}
