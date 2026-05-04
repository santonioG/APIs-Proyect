package com.duoc.learningplatformvalidation.mapper;

import com.duoc.learningplatformvalidation.dto.repartidor.CursoRequest;
import com.duoc.learningplatformvalidation.dto.repartidor.CursoResponse;
import com.duoc.learningplatformvalidation.model.CursoEntity;
import com.duoc.learningplatformvalidation.model.UsuarioEntity;

public class CursoMapper {

    public static CursoEntity toEntity(CursoRequest request) {
        CursoEntity u = new CursoEntity();
        u.setNombre(request.getNombre());
        u.setDescripcion(request.getDescripcion());

        if (request.getProfesorId() != null) {
        UsuarioEntity profe = new UsuarioEntity();
        profe.setId(request.getProfesorId()); // se passa el ID al objeto
        u.setProfesor(profe); // setea el objeto
    }
        return u;
    } 

    public static void updateEntity(CursoRequest request, CursoEntity bd) {
        bd.setNombre(request.getNombre());
        bd.setDescripcion(request.getDescripcion());
        
        if (request.getProfesorId() != null) {
            UsuarioEntity profesor = new UsuarioEntity();
            profesor.setId(request.getProfesorId());
            bd.setProfesor(profesor);
        } else {
            bd.setProfesor(null); // Si el request viene sin ID, el curso queda sin profe
        }
    }

    public static CursoResponse toResponse(CursoEntity u){
        // Sacamos el ID desde el objeto profesor si es que existe
        Long idProfe = (u.getProfesor() != null) ? u.getProfesor().getId() : null;
        return new CursoResponse(u.getId(), u.getNombre(), u.getDescripcion(), idProfe);
    }

}
