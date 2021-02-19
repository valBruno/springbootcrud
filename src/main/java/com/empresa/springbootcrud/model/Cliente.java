package com.empresa.springbootcrud.model;

import com.empresa.springbootcrud.model.dto.ClienteDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /*
     * Mínimo de 3 caracteres;
     * Máximo de 100 caracteres;
     * Campo obrigatório;* Permite apenas letras, espaços e números.
     */
    private String nome;

    /*
     * Sempre deve ser mostrado com máscara;
     * Deve ser persistido na base sem máscara;
     * É um campo obrigatório.
     */
    private String cpf;

    /*
     * Obrigatório preenchimento de CEP, logradouro, bairro, cidade e uf;
     * Opcional complemento;
     * Outros dados não devem ser preenchidos;
     * Deve estar integrado com um serviço de consulta de CEP. Sugestão: https://viacep.com.br/
     * O usuário pode alterar os dados que vieram do serviço de consulta de CEP;
     * O CEP deve ser mostrado com máscara;
     * O CEP deve ser persistido sem máscara.
     */
    private String endereco;

    /*
     * Podem ser cadastrados múltiplos telefones;
     * Pelo menos um telefone deve ser cadastrado;
     * No cadastro de telefone, deve ser informado o tipo de telefone (residencial, comercial e celular) e o número;
     * A máscara de telefone deve ser de acordo com o tipo de telefone (celular possui um digito a mais);
     * o telefone deve ser mostrado com máscara;
     * o telefone deve ser persistido sem máscara.
     */
    @ElementCollection
    private List<String> telefone;

    /*
     * Podem ser cadastrados múltiplos e-mails;
     * Pelo menos um e-mail deve ser cadastrado;
     * Deve ser um e-mail válido.
     */
    @ElementCollection
    private List<String> email;

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
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

    public ClienteDTO toClienteDTO() {
        return new ClienteDTO(this);
    }
}
