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

import com.api.natureza.entity.ParqueEntity;
import com.api.natureza.form.ParqueForm;
import com.api.natureza.service.ParqueService;

@RestController
@RequestMapping("/parque")
public class ParqueController {

	@Autowired
	private ParqueService parqueService;
	
	@GetMapping("/findall")
	public ResponseEntity<List<ParqueEntity>> getAllParque(){
		
		List<ParqueEntity> parques = parqueService.findAllParques();
		
		return ResponseEntity.status(HttpStatus.OK).body(parques);
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<ParqueEntity> saveParque(@RequestBody ParqueForm parque){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(parqueService.saveParque(parque));
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteParque(@PathVariable("id") Long id) {
		
		parqueService.deleteParque(id);
		
	}
	
	@PutMapping("/updatefuncionamento")
	public void updateParqueFuncionamento(@RequestBody ParqueForm parque) {
		
		parqueService.updateFuncionando(parque);
		
	}
	
}
