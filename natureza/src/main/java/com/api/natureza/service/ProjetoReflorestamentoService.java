package com.api.natureza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.natureza.entity.ParqueEntity;
import com.api.natureza.entity.ProjetoReflorestamento;
import com.api.natureza.form.ProjetoReflorestamentoForm;
import com.api.natureza.repository.ParqueRepository;
import com.api.natureza.repository.ProjetoReflorestamentoRepository;

@Service
public class ProjetoReflorestamentoService {

	@Autowired
	private ProjetoReflorestamentoRepository projetoReflorestamentoRepository;
	
	@Autowired
	private ParqueRepository parqueRepository;
	
	public List<ProjetoReflorestamento> findAllProjetosReflorestamento(){
		
		return projetoReflorestamentoRepository.findAll();
		
	}
	
	public ProjetoReflorestamento saveProjetoReflorestamento(ProjetoReflorestamentoForm projeto) {
		
		Optional<ParqueEntity> parque = parqueRepository.findById(projeto.getIdParque());
		ParqueEntity parqueFound = null;
		
		if(parque.isPresent()) {
			parqueFound = parque.get();
		}
		
		
		ProjetoReflorestamento projetoReflorestamento = new ProjetoReflorestamento();
		
		projetoReflorestamento.setTitulo(projeto.getTitulo());
		projetoReflorestamento.setDescricao(projeto.getDescricao());
		projetoReflorestamento.setDataHoraEvento(projeto.getDataHoraEvento());
		projetoReflorestamento.setQuantParticipantes(projeto.getQuantParticipantes());
		projetoReflorestamento.setParque(parqueFound);
		
		return projetoReflorestamentoRepository.save(projetoReflorestamento);
		
	}
	
	public void deleteProjetoReflorestamento(Long id) {
		
		projetoReflorestamentoRepository.deleteById(id);
		
	}
	
	public ProjetoReflorestamento updateProjetoReflorestamento(ProjetoReflorestamentoForm projetoForm) {
		
		Optional<ProjetoReflorestamento> projetoFound = projetoReflorestamentoRepository.findById(projetoForm.getId());
		
		ProjetoReflorestamento projeto = null;
		
		if(projetoFound.isPresent()) {
			projeto = projetoFound.get();
		}
		
		projeto.setTitulo(projetoForm.getTitulo());
		projeto.setDescricao(projetoForm.getDescricao());
		projeto.setDataHoraEvento(projetoForm.getDataHoraEvento());

		return projetoReflorestamentoRepository.save(projeto);
		
	}
	
	public void updateProjetoQuantParticipantes(Long id) {
		
		Optional<ProjetoReflorestamento> projetoFound = projetoReflorestamentoRepository.findById(id);
		
		ProjetoReflorestamento projeto = null;
		
		if(projetoFound.isPresent()) {
			projeto = projetoFound.get();
		}
		
		Long quantParticipantes = projeto.getQuantParticipantes();
		
		projeto.setQuantParticipantes(quantParticipantes + 1);
		
		projetoReflorestamentoRepository.save(projeto);
		
	}
	
}
