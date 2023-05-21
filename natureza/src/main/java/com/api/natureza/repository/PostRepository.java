package com.api.natureza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.natureza.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long>{

}
