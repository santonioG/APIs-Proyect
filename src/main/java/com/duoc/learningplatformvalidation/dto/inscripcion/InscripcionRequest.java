package com.duoc.learningplatformvalidation.dto.inscripcion;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InscripcionRequest {

    @NotNull(message = "El ID del alumno es obligatorio")
    private Long alumnoId;

    @NotNull(message = "El ID del curso es obligatorio")
    private Long cursoId;

}
