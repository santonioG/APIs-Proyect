package com.duoc.learningplatformvalidation.dto.inscripcion;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InscripcionResponse {

    private Long id;

    private Long alumnoId;

    private Long cursoId;

    private LocalDate fechaInscripcion;
}
