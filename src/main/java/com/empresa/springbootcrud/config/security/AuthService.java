package com.empresa.springbootcrud.config.security;

import com.empresa.springbootcrud.model.Usuario;
import com.empresa.springbootcrud.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepo repo;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repo.findByLogin(login);
		if (usuario.isPresent()) {
			return usuario.get();
		}
		
		throw new UsernameNotFoundException("Usuário ou senha inválidos");
	}

}
