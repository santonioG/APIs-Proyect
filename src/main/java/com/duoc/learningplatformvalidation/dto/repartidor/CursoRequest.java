package com.duoc.learningplatformvalidation.dto.repartidor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CursoRequest {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "La descripción del curso no puede estar vacía")
    @Size(min = 10, max = 200, message = "La descripción debe tener entre 10 y 200 caracteres")
    private String descripcion;

    @NotNull(message = "El ID del profesor es obligatorio")
    private Long profesorId;
}
