package com.matc84.cadastro_filmes.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "filme")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private int anoLancamento;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = true)  // Alterado de @Lob para @Column para armazenar caminho
    private String capa;  // Alterado de byte[] para String

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario usuario;

}
