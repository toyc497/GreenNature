package com.api.natureza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.natureza.entity.ParqueEntity;
import com.api.natureza.entity.UsuarioEntity;
import com.api.natureza.form.ParqueForm;
import com.api.natureza.repository.ParqueRepository;
import com.api.natureza.repository.UsuarioRepository;

@Service
public class ParqueService {

	@Autowired
	private ParqueRepository parqueRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<ParqueEntity> findAllParques() {
		
		List<ParqueEntity> parques = parqueRepository.findAll();
		
		System.out.println(parques);
		
		return parques;
		
	}
	
	public ParqueEntity saveParque(ParqueForm parque) {
		
		Optional<UsuarioEntity> usuarioFound = usuarioRepository.findById(parque.getIdUsuario());
		UsuarioEntity usuario = null;
		
		if(usuarioFound.isPresent()) {
			usuario = usuarioFound.get();
		}
			
		ParqueEntity parqueEntity = new ParqueEntity();
		parqueEntity.setNome(parque.getNome());
		parqueEntity.setLocalizacao(parque.getLocalizacao());
		parqueEntity.setFuncionando(parque.isFuncionando());
		parqueEntity.setUsuario(usuario);
		
		return parqueRepository.save(parqueEntity);
		
	}
	
	public void deleteParque(Long id) {
		
		parqueRepository.deleteById(id);
		
	}
	
	public void updateFuncionando(ParqueForm parqueForm) {
		
		Optional<ParqueEntity> parqueFound = parqueRepository.findById(parqueForm.getId());
		ParqueEntity parque = null;
		
		if(parqueFound.isPresent()) {
			parque = parqueFound.get();
		}
		
		parque.setFuncionando(parqueForm.isFuncionando());

		parqueRepository.save(parque);
		
	}
	
}
