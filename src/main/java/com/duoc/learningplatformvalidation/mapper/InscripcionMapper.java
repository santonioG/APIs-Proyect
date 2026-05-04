package com.duoc.learningplatformvalidation.mapper;

import com.duoc.learningplatformvalidation.dto.inscripcion.InscripcionRequest;
import com.duoc.learningplatformvalidation.dto.inscripcion.InscripcionResponse;
import com.duoc.learningplatformvalidation.model.CursoEntity;
import com.duoc.learningplatformvalidation.model.InscripcionEntity;
import com.duoc.learningplatformvalidation.model.UsuarioEntity;

public class InscripcionMapper {
    

public static InscripcionEntity toEntity(InscripcionRequest request) {
        InscripcionEntity inscripcion = new InscripcionEntity();

        // Convertimos el ID del curso a un objeto CursoEntity
        if (request.getCursoId() != null) {
            CursoEntity curso = new CursoEntity();
            curso.setId(request.getCursoId());
            inscripcion.setCurso(curso);
        }

        // Convertimos el ID del alumno a un objeto UsuarioEntity
        if (request.getAlumnoId() != null) {
            UsuarioEntity alumno = new UsuarioEntity();
            alumno.setId(request.getAlumnoId());
            inscripcion.setAlumno(alumno);
        }

        return inscripcion; // Retornamos la entidad creada a partir del request
    } 

    public static void updateEntity(InscripcionRequest request, InscripcionEntity bd) {

        // Actualizamos el curso si viene en el request
        if (request.getCursoId() != null) {
            CursoEntity curso = new CursoEntity();
            curso.setId(request.getCursoId());
            bd.setCurso(curso);
        }

        // Actualizamos el alumno si viene en el request
        if (request.getAlumnoId() != null) {
            UsuarioEntity alumno = new UsuarioEntity();
            alumno.setId(request.getAlumnoId());
            bd.setAlumno(alumno);
        }
        
    }

    public static InscripcionResponse toResponse(InscripcionEntity u) {
        // Obtenemos los IDs de los objetos relacionados, manejando el caso de que puedan ser null
        Long idCurso = (u.getCurso() != null) ? u.getCurso().getId() : null;
        Long idalumno = (u.getAlumno() != null) ? u.getAlumno().getId() : null;

        return new InscripcionResponse(
            u.getId(), 
            idCurso, 
            idalumno, 
            u.getFechaInscripcion() // pasamos la fecha al Response
        );
    }
}
