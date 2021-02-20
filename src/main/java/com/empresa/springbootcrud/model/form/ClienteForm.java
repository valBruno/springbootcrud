package com.empresa.springbootcrud.model.form;

import com.empresa.springbootcrud.model.Cliente;
import com.empresa.springbootcrud.model.Telefone;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


public class ClienteForm {

    @NotNull
    @Length(min = 3, max = 100)
    @NotEmpty
    private String nome;
    @NotNull
    @CPF
    private String cpf;
    private EnderecoForm endereco;
    @NotEmpty
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

    public Cliente toCliente() {
        return new Cliente(this);
    }
}
