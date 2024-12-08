package com.matc84.cadastro_filmes.service;


import com.matc84.cadastro_filmes.dto.LoginDTO;
import com.matc84.cadastro_filmes.model.Usuario;
import com.matc84.cadastro_filmes.security.JwtService;
import com.matc84.cadastro_filmes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    public String autenticar(LoginDTO loginDTO) {

        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByEmail(loginDTO.getEmail());

        if (
                usuarioEncontrado.isPresent()
                &&
                usuarioService.verificarSenha(loginDTO.getSenha(), usuarioEncontrado.get().getSenha())
        ) {
            return jwtUtil.gerarToken(loginDTO.getEmail());
        }

        return null;
    }
}