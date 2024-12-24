package com.matc84.cadastro_filmes.controller;

import com.matc84.cadastro_filmes.dto.UsuarioRequestDTO;
import com.matc84.cadastro_filmes.dto.UsuarioDTO;
import com.matc84.cadastro_filmes.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.Collections;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity cadastrarUsuario(@Valid @RequestBody UsuarioRequestDTO usuarioRequest) {
        try {
            UsuarioDTO usuario = usuarioService.cadastrarUsuario(usuarioRequest);
            return ResponseEntity.status(201).body(usuario);
        } catch (Exception e) {
            return ResponseEntity.status(422) .body(Collections.singletonMap("message", e.getMessage()));
        }
    }
}
