package com.duoc.learningplatformvalidation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.learningplatformvalidation.dto.inscripcion.InscripcionRequest;
import com.duoc.learningplatformvalidation.dto.inscripcion.InscripcionResponse;
import com.duoc.learningplatformvalidation.service.InscripcionService;

import jakarta.validation.Valid;
import lombok.NonNull;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

        private final InscripcionService service;
    public InscripcionController(InscripcionService InscripcionService) {
        this.service = InscripcionService;
    }

    @GetMapping("/curso/{id}")
    public ResponseEntity<List<InscripcionResponse>> findByCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(service.findByCurso(cursoId));
    }

    @PostMapping
    public ResponseEntity<InscripcionResponse> create(@Valid @RequestBody InscripcionRequest request) {
        InscripcionResponse created = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @NonNull Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
