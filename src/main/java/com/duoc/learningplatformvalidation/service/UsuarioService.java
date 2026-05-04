package com.duoc.learningplatformvalidation.service;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.duoc.learningplatformvalidation.dto.usuario.UsuarioRequest;
import com.duoc.learningplatformvalidation.dto.usuario.UsuarioResponse;
import com.duoc.learningplatformvalidation.exception.NotFoundException;
import com.duoc.learningplatformvalidation.mapper.UsuarioMapper;
import com.duoc.learningplatformvalidation.model.UsuarioEntity;
import com.duoc.learningplatformvalidation.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.repo = usuarioRepository;
    }   

    public List<UsuarioResponse> findAll() { //obtener todos los usuarios
        return repo.findAll().stream().map(UsuarioMapper::toResponse).toList();
    }

    public UsuarioResponse findById(@NonNull Long id) { //obtener un usuario por id
        UsuarioEntity entity = repo.findById(id).orElseThrow(() -> new NotFoundException("Usuario no encontrado con id: " + id));
        return UsuarioMapper.toResponse(entity);
    }

    public UsuarioResponse create(UsuarioRequest request) { //crear un nuevo usuario
        UsuarioEntity entity = UsuarioMapper.toEntity(request);
        UsuarioEntity saved = repo.save(entity);
        
        return UsuarioMapper.toResponse(saved);
    }

    public UsuarioResponse update(Long id, UsuarioRequest request) { //actualizar un usuario existente
        
        UsuarioEntity entity = repo.findById(id).orElseThrow(() -> new NotFoundException("Usuario no encontrado con id: " + id));
        UsuarioMapper.updateEntity(request, entity);
        UsuarioEntity updated = repo.save(entity);

        return UsuarioMapper.toResponse(updated);
    }

    public void delete(@NonNull Long id) { //eliminar un usuario por id
        
        UsuarioEntity entity = repo.findById(id).orElseThrow(() -> new NotFoundException("Usuario no encontrado con id: " + id));
        repo.delete(entity);
    } 
}
