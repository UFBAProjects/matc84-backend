package com.matc84.cadastro_filmes.service;

import com.matc84.cadastro_filmes.dto.FilmeDTO;
import com.matc84.cadastro_filmes.model.Filme;
import com.matc84.cadastro_filmes.model.Usuario;
import com.matc84.cadastro_filmes.repository.FilmeRepository;
import com.matc84.cadastro_filmes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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
        Usuario usuario = usuarioRepository.findById(filmeDTO.getUser_id())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado para o ID: " + filmeDTO.getUser_id()));

        Filme filme = toEntity(filmeDTO, usuario);
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

    private Filme toEntity(FilmeDTO dto, Usuario usuario) {
        return new Filme(null, dto.getTitulo(), dto.getGenero(), dto.getAnoLancamento(), dto.getDescricao(), dto.getCapa(), usuario);
    }

    private FilmeDTO toDTO(Filme filme) {
        FilmeDTO dto = new FilmeDTO();
        dto.setTitulo(filme.getTitulo());
        dto.setGenero(filme.getGenero());
        dto.setAnoLancamento(filme.getAnoLancamento());
        dto.setDescricao(filme.getDescricao());
        dto.setCapa(filme.getCapa());
        dto.setUser_id(filme.getUser().getId());
        return dto;
    }

    public List<FilmeDTO> buscarFilmesPorUsuario(Long user_id) {
        List<Filme> filmes = filmeRepository.findByUser_id(user_id);
        return filmes.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void deletarFilme(Long id) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado para o ID: " + id));
        filmeRepository.delete(filme);
    }
}

