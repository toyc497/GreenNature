package com.api.natureza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.natureza.entity.ProjetoReflorestamento;
import com.api.natureza.form.ProjetoReflorestamentoForm;
import com.api.natureza.service.ProjetoReflorestamentoService;

@RestController
@RequestMapping("/projetoreflorestamento")
public class ProjetoReflorestamentoController {

	@Autowired
	private ProjetoReflorestamentoService projetoReflorestamentoService;
	
	@GetMapping("/findall")
	public ResponseEntity<List<ProjetoReflorestamento>> getAllProjetos(){
		
		return ResponseEntity.status(HttpStatus.OK).body(projetoReflorestamentoService.findAllProjetosReflorestamento());
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<ProjetoReflorestamento> saveProjeto(@RequestBody ProjetoReflorestamentoForm projetoForm){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(projetoReflorestamentoService.saveProjetoReflorestamento(projetoForm));
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProjeto(@PathVariable("id") Long id) {
		
		projetoReflorestamentoService.deleteProjetoReflorestamento(id);
		
	}
	
	@PutMapping("/put")
	public ResponseEntity<ProjetoReflorestamento> updateProjeto(@RequestBody ProjetoReflorestamentoForm projetoForm){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(projetoReflorestamentoService.updateProjetoReflorestamento(projetoForm));
		
	}
	
	@PutMapping("/putquantparticipantes/{id}")
	public void updateProjetoQuantPart(@PathVariable("id") Long id) {
		
		projetoReflorestamentoService.updateProjetoQuantParticipantes(id);
		
	}
	
}
