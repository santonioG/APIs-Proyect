package com.duoc.learningplatformvalidation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.learningplatformvalidation.dto.usuario.UsuarioRequest;
import com.duoc.learningplatformvalidation.dto.usuario.UsuarioResponse;
import com.duoc.learningplatformvalidation.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;
    public UsuarioController(UsuarioService usuarioService) {
        this.service = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> findAllUsuarios() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findUsuarioById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/create")
    public ResponseEntity<UsuarioResponse> create(@valid @RequestBody UsuarioRequest request) {
        UsuarioResponse created = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<UsuarioResponse> update(@PathVariable Long id, @valid @RequestBody UsuarioRequest request) {
        UsuarioResponse updated = service.update(id, request);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
