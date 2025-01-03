package br.com.earnings.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("ativos")
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_categoria")
    private Long id;
    @Column(length = 30, nullable = false)
    private String nome;
    @Column(length = 5, nullable = false)
    private String sigla;
    @OneToMany(mappedBy = "categoria")
    private List<Ativo> ativos;

}