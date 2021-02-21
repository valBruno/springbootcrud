package com.empresa.springbootcrud.controller;

import com.empresa.springbootcrud.config.security.TokenService;
import com.empresa.springbootcrud.model.Usuario;
import com.empresa.springbootcrud.model.dto.TokenDTO;
import com.empresa.springbootcrud.model.dto.UsuarioDTO;
import com.empresa.springbootcrud.model.form.LoginForm;
import com.empresa.springbootcrud.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepo usuarioRepo;

    @PostMapping
    public ResponseEntity<UsuarioDTO> autenticar(@RequestBody @Valid LoginForm form) {
        UsernamePasswordAuthenticationToken dados = new UsernamePasswordAuthenticationToken(form.getLogin(), form.getSenha());

        try {
            Authentication authentication = authManager.authenticate(dados);
            String token = tokenService.gerarToken(authentication);
            Usuario usuario = (Usuario) authentication.getPrincipal();

            Optional<Usuario> usuarioCompleto = usuarioRepo.findById(usuario.getId());
            UsuarioDTO retorno = usuarioCompleto.get().toUsuarioDTO();
            retorno.setToken(new TokenDTO(token, "Bearer"));
            return ResponseEntity.ok(retorno);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
