package com.empresa.springbootcrud.repository;

import com.empresa.springbootcrud.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepo extends JpaRepository<Cliente, Long> {

    @Query("SELECT DISTINCT c FROM Cliente c LEFT JOIN FETCH c.endereco en LEFT JOIN FETCH c.email em LEFT JOIN FETCH c.telefone tl")
    List<Cliente> listarCompleto();
}
