package com.empresa.springbootcrud.model.dto;

import com.empresa.springbootcrud.model.Cliente;
import com.empresa.springbootcrud.model.Endereco;

import java.util.List;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private Endereco endereco;
    private List<String> telefone;
    private List<String> email;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente c) {
        this.id = c.getId();
        this.nome = c.getNome();
        this.cpf = c.getCpf();
        this.endereco = c.getEndereco();
        this.telefone = c.getTelefone();
        this.email = c.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<String> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<String> telefone) {
        this.telefone = telefone;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }
}
