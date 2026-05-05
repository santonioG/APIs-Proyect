package com.duoc.learningplatformvalidation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.learningplatformvalidation.dto.evaluacion.EvaluacionRequest;
import com.duoc.learningplatformvalidation.dto.evaluacion.EvaluacionResponse;
import com.duoc.learningplatformvalidation.exception.NotFoundException;
import com.duoc.learningplatformvalidation.mapper.EvaluacionMapper;
import com.duoc.learningplatformvalidation.model.EvaluacionEntity;
import com.duoc.learningplatformvalidation.repository.EvaluacionRepository;

@Service
public class EvaluacionService {

        private final EvaluacionRepository repo;
    public EvaluacionService(EvaluacionRepository EvaluacionRepository) {
        this.repo = EvaluacionRepository;
    }   

    public List<EvaluacionResponse> findAll() { //obtener todas los Evaluacions
        return repo.findAll().stream().map(EvaluacionMapper::toResponse).toList();
    }

    public List<EvaluacionResponse> findByCurso(Long cursoId) {
        return repo.findByCursoId(cursoId).stream()
                .map(EvaluacionMapper::toResponse)
                .toList();
    }

     // crear una nueva evaluación
    public EvaluacionResponse create(EvaluacionRequest request) {
        EvaluacionEntity entity = EvaluacionMapper.toEntity(request);
        EvaluacionEntity saved = repo.save(entity);
        
        return EvaluacionMapper.toResponse(saved);
    }

     public EvaluacionResponse update(Long id, EvaluacionRequest request) { //actualizar un Evaluacion existente
        
        EvaluacionEntity entity = repo.findById(id).orElseThrow(() -> new NotFoundException("Evaluacion no encontrado con id: " + id));
        EvaluacionMapper.updateEntity(request, entity);
        EvaluacionEntity updated = repo.save(entity);

        return EvaluacionMapper.toResponse(updated);
    }
}
