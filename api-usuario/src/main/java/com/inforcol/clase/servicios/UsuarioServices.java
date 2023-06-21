package com.inforcol.clase.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inforcol.clase.entidades.Usuario;
import com.inforcol.clase.repositorios.UsuarioRepository;

@Service
public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> getAll(){
		return repository.findAll();
	}
	
	public Usuario buscarUsuario(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Usuario guardar(Usuario usuario) {
		return repository.save(usuario);
	}

}
