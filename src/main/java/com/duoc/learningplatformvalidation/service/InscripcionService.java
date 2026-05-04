package com.duoc.learningplatformvalidation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.learningplatformvalidation.dto.inscripcion.InscripcionRequest;
import com.duoc.learningplatformvalidation.dto.inscripcion.InscripcionResponse;
import com.duoc.learningplatformvalidation.exception.NotFoundException;
import com.duoc.learningplatformvalidation.mapper.InscripcionMapper;
import com.duoc.learningplatformvalidation.model.InscripcionEntity;
import com.duoc.learningplatformvalidation.repository.InscripcionRepository;

import lombok.NonNull;

@Service
public class InscripcionService {

    private final InscripcionRepository repo;
    public InscripcionService(InscripcionRepository repo) {
        this.repo = repo;
    }
    
    // obtener las inscripciones por curso
    public List<InscripcionResponse> findByCurso(Long cursoId) {
        return repo.findByCursoId(cursoId).stream()
                .map(InscripcionMapper::toResponse)
                .toList();
    }

    // crear una nueva inscripción
    public InscripcionResponse create(InscripcionRequest request) {
        InscripcionEntity entity = InscripcionMapper.toEntity(request);
        InscripcionEntity saved = repo.save(entity);
        
        return InscripcionMapper.toResponse(saved);
    }

    // Eliminar una inscripción
    public void delete(@NonNull Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("No se puede eliminar. Inscripción no encontrada con id: " + id);
        }
        repo.deleteById(id);
    }
}
