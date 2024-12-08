package com.matc84.cadastro_filmes.service;
import com.matc84.cadastro_filmes.dto.UsuarioDTO;
import com.matc84.cadastro_filmes.dto.UsuarioRequestDTO;
import com.matc84.cadastro_filmes.model.Usuario;
import com.matc84.cadastro_filmes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
   
    private final UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO cadastrarUsuario(UsuarioRequestDTO usuarioDto) {
        if (usuarioRepository.findByEmail(usuarioDto.getEmail()).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado!");
        }
        usuarioDto.setSenha(passwordEncoder.encode(usuarioDto.getSenha()));

        Usuario usuario = toEntity(usuarioDto);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return toDTO(usuarioSalvo);
    }

    private UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setNome(usuario.getNome());
        return usuarioDTO;
    }

    private Usuario toEntity(UsuarioRequestDTO usuario) {
        return new Usuario(usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }

    public boolean verificarSenha(String senha, String senhaCriptografada) {
        return passwordEncoder.matches(senha, senhaCriptografada);
    }

}
