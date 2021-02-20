package com.empresa.springbootcrud.repository;

import com.empresa.springbootcrud.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo extends JpaRepository<Cliente, Long> {
}
