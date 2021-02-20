package com.empresa.springbootcrud.model.dto;

public class TokenDTO {

    private String token;
    private String tipo;

    public TokenDTO(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }

    public TokenDTO() {
    }

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }

}
