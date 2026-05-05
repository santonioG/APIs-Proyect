package com.duoc.learningplatformvalidation.dto.evaluacion;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EvaluacionResponse {

    private Long id;

    private String nombre;

    private Long cursoId;

    private int puntaje;

    private LocalDate fechaEvaluacion;
}
