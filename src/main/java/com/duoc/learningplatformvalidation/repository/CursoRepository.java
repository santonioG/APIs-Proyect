package com.duoc.learningplatformvalidation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.learningplatformvalidation.model.CursoEntity;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, Long>{
   
}
