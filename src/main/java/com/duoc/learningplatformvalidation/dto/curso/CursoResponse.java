package com.duoc.learningplatformvalidation.dto.curso;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CursoResponse {

    private Long id;

    private String nombre;

    private String descripcion;

    private Long profesorId;
}
