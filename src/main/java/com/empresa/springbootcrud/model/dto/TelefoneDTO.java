package com.empresa.springbootcrud.model.dto;

import com.empresa.springbootcrud.enums.TipoTelefoneEnum;
import com.empresa.springbootcrud.model.Telefone;

import java.util.Set;
import java.util.stream.Collectors;

public class TelefoneDTO {

    private TipoTelefoneEnum tipo;
    private String numero;

    public TelefoneDTO(Telefone t) {
        this.tipo = t.getTipo();
        this.numero = t.getNumero();
    }

    public TelefoneDTO() {
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

    public static Set<TelefoneDTO> toSetTelefoneDTO(Set<Telefone> telefones) {
        return telefones.stream().map(TelefoneDTO::new).collect(Collectors.toSet());
    }
}
