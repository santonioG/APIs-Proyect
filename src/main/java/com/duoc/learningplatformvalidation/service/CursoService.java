package com.duoc.learningplatformvalidation.service;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.duoc.learningplatformvalidation.dto.repartidor.CursoRequest;
import com.duoc.learningplatformvalidation.dto.repartidor.CursoResponse;
import com.duoc.learningplatformvalidation.exception.NotFoundException;
import com.duoc.learningplatformvalidation.mapper.CursoMapper;
import com.duoc.learningplatformvalidation.model.CursoEntity;
import com.duoc.learningplatformvalidation.repository.CursoRepository;

@Service
public class CursoService {

        private final CursoRepository repo;
    public CursoService(CursoRepository CursoRepository) {
        this.repo = CursoRepository;
    }   

    public List<CursoResponse> findAll() { //obtener todos los Cursos
        return repo.findAll().stream().map(CursoMapper::toResponse).toList();
    }

    public CursoResponse findById(@NonNull Long id) { //obtener un Curso por id
        CursoEntity entity = repo.findById(id).orElseThrow(() -> new NotFoundException("Curso no encontrado con id: " + id));
        return CursoMapper.toResponse(entity);
    }

    public CursoResponse create(CursoRequest request) { //crear un nuevo Curso
        CursoEntity entity = CursoMapper.toEntity(request);
        CursoEntity saved = repo.save(entity);
        
        return CursoMapper.toResponse(saved);
    }

    public CursoResponse update(Long id, CursoRequest request) { //actualizar un Curso existente
        
        CursoEntity entity = repo.findById(id).orElseThrow(() -> new NotFoundException("Curso no encontrado con id: " + id));
        CursoMapper.updateEntity(request, entity);
        CursoEntity updated = repo.save(entity);

        return CursoMapper.toResponse(updated);
    }

    public void delete(@NonNull Long id) { //eliminar un Curso por id
        
        CursoEntity entity = repo.findById(id).orElseThrow(() -> new NotFoundException("Curso no encontrado con id: " + id));
        repo.delete(entity);
    } 
}
