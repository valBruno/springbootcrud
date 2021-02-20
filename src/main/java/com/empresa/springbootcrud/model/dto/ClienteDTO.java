package com.empresa.springbootcrud.model.dto;

import com.empresa.springbootcrud.model.Cliente;
import com.empresa.springbootcrud.model.Endereco;
import com.empresa.springbootcrud.model.Telefone;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private EnderecoDTO endereco;
    private Set<TelefoneDTO> telefone = new HashSet<>();
    private Set<String> email = new HashSet<>();

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente c) {
        this.id = c.getId();
        this.nome = c.getNome();
        this.cpf = c.getCpf();
        this.endereco = Optional.ofNullable(c).map(Cliente::getEndereco).map(Endereco::toEnderecoDTO).orElse(null);
        this.telefone = Optional.ofNullable(c).map(Cliente::getTelefone).map(TelefoneDTO::toSetTelefoneDTO).orElse(null);
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

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public Set<TelefoneDTO> getTelefone() {
        return telefone;
    }

    public void setTelefone(Set<TelefoneDTO> telefone) {
        this.telefone = telefone;
    }

    public Set<String> getEmail() {
        return email;
    }

    public void setEmail(Set<String> email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco=" + endereco +
                ", telefone=" + telefone +
                ", email=" + email +
                '}';
    }
}
