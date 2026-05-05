package com.duoc.learningplatformvalidation.dto.evaluacion;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EvaluacionRequest {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotNull(message = "El ID del curso es obligatorio")
    private Long cursoId;
    
    @NotNull(message = "El puntaje es obligatorio")
    @Min(value = 0, message = "El puntaje mínimo es 0")
    @Max(value = 100, message = "El puntaje máximo es 100")
    private int puntaje;

}
