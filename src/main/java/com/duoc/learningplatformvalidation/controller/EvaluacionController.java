package com.duoc.learningplatformvalidation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.learningplatformvalidation.dto.evaluacion.EvaluacionRequest;
import com.duoc.learningplatformvalidation.dto.evaluacion.EvaluacionResponse;
import com.duoc.learningplatformvalidation.service.EvaluacionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

            private final EvaluacionService service;
    public EvaluacionController(EvaluacionService EvaluacionService) {
        this.service = EvaluacionService;
    }

    @GetMapping 
    public ResponseEntity<List<EvaluacionResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/cursos/{cursoId}")
    public ResponseEntity<List<EvaluacionResponse>> findByCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(service.findByCurso(cursoId));
    }

    @PostMapping 
    public ResponseEntity<EvaluacionResponse> create(@Valid @RequestBody EvaluacionRequest request) {
        EvaluacionResponse created = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvaluacionResponse> update(@PathVariable Long id, @Valid @RequestBody EvaluacionRequest request) {
        EvaluacionResponse updated = service.update(id, request);
        return ResponseEntity.ok(updated);
    }
}
