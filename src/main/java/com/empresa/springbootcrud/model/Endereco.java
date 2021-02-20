package com.empresa.springbootcrud.model;

import com.empresa.springbootcrud.model.dto.ClienteDTO;
import com.empresa.springbootcrud.model.dto.EnderecoDTO;
import com.empresa.springbootcrud.model.form.EnderecoForm;

import javax.persistence.*;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;

    public Endereco() {
    }

    public Endereco(EnderecoForm ef) {
        this.cep = ef.getCep();
        this.logradouro = ef.getLogradouro();
        this.bairro = ef.getBairro();
        this.cidade = ef.getCidade();
        this.uf = ef.getUf();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public EnderecoDTO toEnderecoDTO() {
        return new EnderecoDTO(this);
    }


    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }

    public void atualizar(EnderecoForm e) {
        if(e.getCep()!=null) this.cep = e.getCep();
        if(e.getLogradouro()!=null) this.logradouro = e.getLogradouro();
        if(e.getBairro()!=null) this.bairro = e.getBairro();
        if(e.getCidade()!=null) this.cidade = e.getCidade();
        if(e.getUf()!=null) this.uf = e.getUf();
    }
}
