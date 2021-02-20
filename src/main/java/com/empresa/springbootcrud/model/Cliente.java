package com.empresa.springbootcrud.model;

import com.empresa.springbootcrud.model.dto.ClienteDTO;
import com.empresa.springbootcrud.model.form.ClienteForm;
import com.empresa.springbootcrud.model.update.ClienteUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    /*
     * Podem ser cadastrados múltiplos telefones;
     * Pelo menos um telefone deve ser cadastrado;
     * No cadastro de telefone, deve ser informado o tipo de telefone (residencial, comercial e celular) e o número;
     * A máscara de telefone deve ser de acordo com o tipo de telefone (celular possui um digito a mais);
     * o telefone deve ser mostrado com máscara;
     * o telefone deve ser persistido sem máscara.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cliente_id")
    private Set<Telefone> telefone = new HashSet<>();

    /*
     * Podem ser cadastrados múltiplos e-mails;
     * Pelo menos um e-mail deve ser cadastrado;
     * Deve ser um e-mail válido.
     */
    @ElementCollection
    private Set<String> email = new HashSet<>();

    public Cliente(ClienteForm cf) {
        this.nome = cf.getNome();
        this.cpf = cf.getCpf();
        this.endereco = cf.getEndereco().toEndereco();
        this.telefone = new HashSet<Telefone>(cf.getTelefone());
        this.email = new HashSet<>(cf.getEmail());
    }

    public Cliente() {
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

    public Set<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(Set<Telefone> telefone) {
        this.telefone = telefone;
    }

    public Set<String> getEmail() {
        return email;
    }

    public void setEmail(Set<String> email) {
        this.email = email;
    }

    public ClienteDTO toClienteDTO() {
        return new ClienteDTO(this);
    }

    public void atualizar(ClienteUpdate c) {
        if(c.getNome()!=null) this.nome = c.getNome();
        if(c.getCpf()!=null) this.cpf = c.getCpf();
        if(c.getEndereco()!=null) this.endereco.atualizar(c.getEndereco());
        if(c.getTelefone()!=null) this.telefone = new HashSet<Telefone>(c.getTelefone());
        if(c.getEmail()!=null) this.email = new HashSet<>(c.getEmail());
    }
}
