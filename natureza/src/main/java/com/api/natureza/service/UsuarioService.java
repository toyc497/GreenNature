package com.api.natureza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.natureza.entity.UsuarioEntity;
import com.api.natureza.form.UsuarioForm;
import com.api.natureza.form.UsuarioLogin;
import com.api.natureza.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioEntity saveUsuario(UsuarioEntity usuario) {
		
		return usuarioRepository.save(usuario);
		
	}
	
	public List<UsuarioEntity> findAll(){
		
		return usuarioRepository.findAll();
		
	}
	
	public UsuarioEntity updateUsuario(UsuarioForm userForm) {
		
		Optional<UsuarioEntity> usuario = usuarioRepository.findById(userForm.getId());
		
		UsuarioEntity user = null;
		
		if(usuario.isPresent()) {
			
			user = usuario.get();
			
		}
		
		user.setEmail(userForm.getEmail());
		user.setSenha(userForm.getSenha());
		user.setTipoUsuario(userForm.getTipoUsuario());
		
		return usuarioRepository.save(user);
		
	}
	
	public void deleteUsuario(Long id) {
		
		usuarioRepository.deleteById(id);
		
	}
	
	public boolean login(UsuarioLogin usuario) {
		
		UsuarioEntity usuarioBD = usuarioRepository.findByEmail(usuario.getEmail());
		
		boolean success = false;
		
		if(usuario.getSenha().equals(usuarioBD.getSenha())) {
			
			success = true;
			
		}
		
		return success;
		
	}
	
}
