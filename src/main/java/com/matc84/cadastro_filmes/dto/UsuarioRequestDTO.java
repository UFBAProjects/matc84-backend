package com.matc84.cadastro_filmes.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDTO {
    private String nome;
    private String email;
    private String senha;
}