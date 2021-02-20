package com.empresa.springbootcrud.repository;

import com.empresa.springbootcrud.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByLogin(String login);

}
