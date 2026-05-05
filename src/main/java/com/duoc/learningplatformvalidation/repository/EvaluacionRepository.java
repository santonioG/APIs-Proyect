package com.duoc.learningplatformvalidation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.learningplatformvalidation.model.EvaluacionEntity;

@Repository
public interface EvaluacionRepository extends JpaRepository<EvaluacionEntity, Long> {
    List<EvaluacionEntity> findByCursoId(Long cursoId);
}
