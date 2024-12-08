package com.matc84.cadastro_filmes.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    private String email;
    private String senha;
}
