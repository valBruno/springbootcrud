package com.empresa.springbootcrud.model.dto;

import com.empresa.springbootcrud.model.Endereco;

public class EnderecoDTO {

    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;

    public EnderecoDTO() {
    }

    public EnderecoDTO(Endereco e) {
        this.cep = e.getCep();
        this.logradouro = e.getLogradouro();
        this.bairro = e.getBairro();
        this.cidade = e.getCidade();
        this.uf = e.getUf();
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

    @Override
    public String toString() {
        return "{" +
                "  cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
