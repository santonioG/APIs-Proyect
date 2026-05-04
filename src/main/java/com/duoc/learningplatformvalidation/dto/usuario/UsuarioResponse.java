package com.duoc.learningplatformvalidation.dto.usuario;

import com.duoc.learningplatformvalidation.model.Rol;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioResponse {

    private Long id;

    private String nombre;

    private String correo;

    private Rol rol;
}
