package com.empresa.springbootcrud.model.update;

import com.empresa.springbootcrud.model.Telefone;
import com.empresa.springbootcrud.model.form.EnderecoForm;

import java.util.List;


public class ClienteUpdate {

    private String nome;
    private String cpf;
    private EnderecoForm endereco;
    private List<Telefone> telefone;
    private List<String> email;

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

    public EnderecoForm getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoForm endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

}
