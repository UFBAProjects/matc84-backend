package com.matc84.cadastro_filmes.controller;

import com.matc84.cadastro_filmes.dto.FilmeDTO;
import com.matc84.cadastro_filmes.service.FilmeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("filmes")
public class FilmeController {
    private final FilmeService filmeService;
    
    @Autowired
    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<FilmeDTO> cadastrarFilme(@RequestBody FilmeDTO filmeDTO) {
        FilmeDTO filmeSalvo = filmeService.cadastrarFilme(filmeDTO);
        return ResponseEntity.status(201).body(filmeSalvo);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<FilmeDTO> atualizarFilme(@PathVariable Long id, @RequestBody FilmeDTO novoFilmeDTO) {
        FilmeDTO filmeAtualizado = filmeService.atualizarFilme(id, novoFilmeDTO);
        return ResponseEntity.ok(filmeAtualizado);
    }

    @GetMapping("/listar/{user_id}")
    public ResponseEntity<List<FilmeDTO>> buscarFilmesPorUsuario(@PathVariable Long user_id) {
        List<FilmeDTO> filmes = filmeService.buscarFilmesPorUsuario(user_id);
        return ResponseEntity.ok(filmes);
    }

}
