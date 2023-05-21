package com.api.natureza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.natureza.entity.ProjetoReflorestamento;

@Repository
public interface ProjetoReflorestamentoRepository extends JpaRepository<ProjetoReflorestamento, Long>{

}
