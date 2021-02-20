package com.empresa.springbootcrud.controller;

import com.empresa.springbootcrud.config.security.TokenService;
import com.empresa.springbootcrud.model.dto.TokenDTO;
import com.empresa.springbootcrud.model.form.LoginForm;
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

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDTO> autenticar(@RequestBody @Valid LoginForm form) {
        UsernamePasswordAuthenticationToken dados = new UsernamePasswordAuthenticationToken(form.getLogin(), form.getSenha());

        try {
            Authentication authentication = authManager.authenticate(dados);
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
