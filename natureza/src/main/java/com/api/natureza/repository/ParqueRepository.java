package com.api.natureza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.natureza.entity.ParqueEntity;

@Repository
public interface ParqueRepository extends JpaRepository<ParqueEntity, Long>{

}
