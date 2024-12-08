package com.matc84.cadastro_filmes.controller;

import com.matc84.cadastro_filmes.security.JwtService;
import com.matc84.cadastro_filmes.dto.LoginDTO;
import com.matc84.cadastro_filmes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.matc84.cadastro_filmes.service.AuthService;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private JwtService jwtUtil;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
        String token = authService.autenticar(loginDTO);

        if (token != null) {
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        }

        return ResponseEntity.status(401).body(Collections.singletonMap("message", "Email ou senha inválida!"));
    }
}
