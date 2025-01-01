package br.com.earnings.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}