package com.matc84.cadastro_filmes.dto;
import lombok.*;

@Getter
@Setter
public class FilmeDTO {
    private String titulo;
    private String genero;
    private int anoLancamento;
    private String descricao;
    private String capa;  // Alterado de byte[] para String
    private Long user_id;

}
