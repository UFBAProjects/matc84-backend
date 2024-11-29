package com.matc84.cadastro_filmes.service;

import com.matc84.cadastro_filmes.repository.FilmeRepository;
import com.matc84.cadastro_filmes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {
    private final FilmeRepository filmeRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public FilmeService(FilmeRepository filmeRepository, UsuarioRepository usuarioRepository) {
        this.filmeRepository = filmeRepository;
        this.usuarioRepository = usuarioRepository;
    }
}
