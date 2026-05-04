package com.duoc.learningplatformvalidation.mapper;

import com.duoc.learningplatformvalidation.dto.usuario.UsuarioRequest;
import com.duoc.learningplatformvalidation.dto.usuario.UsuarioResponse;
import com.duoc.learningplatformvalidation.model.UsuarioEntity;

public class UsuarioMapper {

    public static UsuarioEntity toEntity(UsuarioRequest request) {
        UsuarioEntity u = new UsuarioEntity();
        u.setNombre(request.getNombre());
        u.setCorreo(request.getCorreo());
        u.setContraseña(request.getContraseña());
        u.setRol(request.getRol());
        return u;
    } 

    public static void updateEntity(UsuarioRequest request, UsuarioEntity bd) {
        bd.setNombre(request.getNombre());
        bd.setCorreo(request.getCorreo());
        bd.setContraseña(request.getContraseña());
        bd.setRol(request.getRol());
    }

    public static UsuarioResponse toResponse(UsuarioEntity u){
        return new UsuarioResponse(u.getId(), u.getNombre(), u.getCorreo(), u.getRol());
    }
}
