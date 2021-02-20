package com.empresa.springbootcrud.model;

import com.empresa.springbootcrud.enums.TipoTelefoneEnum;
import com.empresa.springbootcrud.model.dto.TelefoneDTO;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoTelefoneEnum tipo;

    private String numero;

    public Telefone(TipoTelefoneEnum tipo, String numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    public Telefone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoTelefoneEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefoneEnum tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TelefoneDTO toTelefoneDTO() {
        return new TelefoneDTO(this);
    }

    public List<TelefoneDTO> toSetTelefoneDTO(Set<Telefone> telefones) {
        return telefones.stream().map(TelefoneDTO::new).collect(Collectors.toList());
    }
}
