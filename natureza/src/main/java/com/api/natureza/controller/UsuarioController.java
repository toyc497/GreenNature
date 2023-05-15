package com.api.natureza.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@GetMapping("/mens")
	public String mensagemTeste() {
		return "FUNCIONANDO";
	}
	
}
