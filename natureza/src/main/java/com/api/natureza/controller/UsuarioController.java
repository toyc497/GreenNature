package com.api.natureza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.natureza.entity.UsuarioEntity;
import com.api.natureza.form.UsuarioForm;
import com.api.natureza.form.UsuarioLogin;
import com.api.natureza.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/mens")
	public String mensagemTeste() {
		return "FUNCIONANDO";
	}
	
	@PostMapping("/save")
	public ResponseEntity<UsuarioEntity> saveUsuario(@RequestBody UsuarioEntity usuario) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUsuario(usuario));
		
	}
	
	@GetMapping("/findall")
	public ResponseEntity<List<UsuarioEntity>> getAllUsuarios(){
		
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<UsuarioEntity> updateUsuario(@RequestBody UsuarioForm usuario){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.updateUsuario(usuario));
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUsuario(@PathVariable("id") Long id) {
		
		usuarioService.deleteUsuario(id);
		
	}
	
	@PostMapping("/login")
	public boolean loginUsuario(@RequestBody UsuarioLogin usuario){
		
		return usuarioService.login(usuario);
		
	}
	
}
