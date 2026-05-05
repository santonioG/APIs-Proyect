package com.duoc.learningplatformvalidation.mapper;

import com.duoc.learningplatformvalidation.dto.evaluacion.EvaluacionRequest;
import com.duoc.learningplatformvalidation.dto.evaluacion.EvaluacionResponse;
import com.duoc.learningplatformvalidation.model.CursoEntity;
import com.duoc.learningplatformvalidation.model.EvaluacionEntity;

public class EvaluacionMapper {


public static EvaluacionEntity toEntity(EvaluacionRequest request) {
        EvaluacionEntity evaluacion = new EvaluacionEntity();
        
        evaluacion.setNombre(request.getNombre());
        evaluacion.setPuntaje(request.getPuntaje());

        if (request.getCursoId() != null) {
            CursoEntity curso = new CursoEntity();
            curso.setId(request.getCursoId());
            evaluacion.setCurso(curso);
        }
        return evaluacion;
    } 

    public static void updateEntity(EvaluacionRequest request, EvaluacionEntity bd) {
        bd.setNombre(request.getNombre());
        bd.setPuntaje(request.getPuntaje());

        if (request.getCursoId() != null) {
            CursoEntity curso = new CursoEntity();
            curso.setId(request.getCursoId());
            bd.setCurso(curso);
        }
    }

    public static EvaluacionResponse toResponse(EvaluacionEntity u) {
        Long idCurso = (u.getCurso() != null) ? u.getCurso().getId() : null;

        return new EvaluacionResponse(
            u.getId(), 
            u.getNombre(),    
            idCurso, 
            u.getPuntaje(), 
            u.getFechaEvaluacion()
        );
    }
}


