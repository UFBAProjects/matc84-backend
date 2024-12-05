package com.matc84.cadastro_filmes.service;

import com.matc84.cadastro_filmes.dto.FilmeDTO;
import com.matc84.cadastro_filmes.model.Filme;
import com.matc84.cadastro_filmes.repository.FilmeRepository;
import com.matc84.cadastro_filmes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmeService {
    private final FilmeRepository filmeRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public FilmeService(FilmeRepository filmeRepository, UsuarioRepository usuarioRepository) {
        this.filmeRepository = filmeRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public FilmeDTO cadastrarFilme(FilmeDTO filmeDTO) {
        Filme filme = toEntity(filmeDTO);
        Filme filmeSalvo = filmeRepository.save(filme);
        return toDTO(filmeSalvo);
    }

    public FilmeDTO atualizarFilme(Long id, FilmeDTO novoFilmeDTO) {
        Filme filmeExistente = filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado para o ID: " + id));

        filmeExistente.setTitulo(novoFilmeDTO.getTitulo());
        filmeExistente.setGenero(novoFilmeDTO.getGenero());
        filmeExistente.setAnoLancamento(novoFilmeDTO.getAnoLancamento());
        filmeExistente.setDescricao(novoFilmeDTO.getDescricao());
        filmeExistente.setCapa(novoFilmeDTO.getCapa());

        Filme filmeAtualizado = filmeRepository.save(filmeExistente);
        return toDTO(filmeAtualizado);
    }

    private Filme toEntity(FilmeDTO dto) {
        return new Filme(null, dto.getTitulo(), dto.getGenero(), dto.getAnoLancamento(), dto.getDescricao(), dto.getCapa(), null);
    }

    private FilmeDTO toDTO(Filme filme) {
        FilmeDTO dto = new FilmeDTO();
        dto.setTitulo(filme.getTitulo());
        dto.setGenero(filme.getGenero());
        dto.setAnoLancamento(filme.getAnoLancamento());
        dto.setDescricao(filme.getDescricao());
        dto.setCapa(filme.getCapa());
        return dto;
    }
}
