package com.matc84.cadastro_filmes.dto;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Getter
@Setter
public class FilmeDTO {
    private Long id;

    @NotBlank(message = "Título é obrigatório")
    @Size(max = 255, message = "O título deve ter no máximo 255 caracteres")
    private String titulo;

    @NotBlank(message = "Gênero é obrigatório")
    @Size(max = 100, message = "O gênero deve ter no máximo 100 caracteres")
    private String genero;

    @NotNull(message = "Ano de lançamento é obrigatório")
    @Positive(message = "O ano de lançamento deve ser um valor positivo")
    private int anoLancamento;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
    private String descricao;

    @NotBlank(message = "Capa é obrigatória")
    @Pattern(regexp = "^(http|https)://.*$", message = "A capa deve ser um link válido")
    private String capa;

    @NotNull(message = "Usuário é obrigatório")
    private Long user_id;
}
