package com.matc84.cadastro_filmes.controller;

import com.matc84.cadastro_filmes.dto.UsuarioDTO;
import com.matc84.cadastro_filmes.dto.LoginDTO;
import com.matc84.cadastro_filmes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.matc84.cadastro_filmes.service.AuthService;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
        String token = authService.autenticar(loginDTO);

        if (token != null) {
            UsuarioDTO usuario = usuarioService.getUsuarioPorEmail(loginDTO.getEmail());

            Map<String, Object> resposta = new HashMap<>();
            resposta.put("token", token);
            resposta.put("usuario", usuario);

            return ResponseEntity.ok(resposta);
        }

        return ResponseEntity.status(401).body(Collections.singletonMap("message", "Email ou senha inválida!"));
    }
}
