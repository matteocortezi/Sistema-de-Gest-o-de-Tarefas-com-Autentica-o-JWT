package com.fiap.checkpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthController {
    @RestController
    @RequestMapping("/login")
    public class AutenticacaoController {
        @Autowired
        private UsuarioRepository usuarioRepository;
        @Autowired
        private PasswordEncoder passwordEncoder;
        @PostMapping("register")
        @Transactional
        public ResponseEntity<DetalhesUsuarioDto> post(@RequestBody @Valid CadastroUsuarioDto dto, UriComponentsBuilder builder){
            var usuario = new Usuario(dto.login(), passwordEncoder.encode(dto.senha()));
            usuarioRepository.save(usuario);
            var uri = builder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
            return ResponseEntity.created(uri).body(new DetalhesUsuarioDto(usuario));
        }
    }
}
