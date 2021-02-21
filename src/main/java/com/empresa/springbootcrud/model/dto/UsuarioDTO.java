package com.empresa.springbootcrud.model.dto;

import com.empresa.springbootcrud.model.Perfil;
import com.empresa.springbootcrud.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDTO {

    private Long id;
    private String login;
    private List<String> perfis = new ArrayList<>();
    private TokenDTO token;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario u) {
        this.id = u.getId();
        this.login = u.getLogin();
        this.perfis = u.getPerfis().stream().map(Perfil::getNome).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<String> perfis) {
        this.perfis = perfis;
    }

    public TokenDTO getToken() {
        return token;
    }

    public void setToken(TokenDTO token) {
        this.token = token;
    }
}
