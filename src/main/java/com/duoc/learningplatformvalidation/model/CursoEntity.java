package com.duoc.learningplatformvalidation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "curso")
@Getter
@Setter
public class CursoEntity {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del curso no puede estar vacío")
    private String nombre;

    @NotBlank(message = "La descripción del curso no puede estar vacía")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "profesor_id", nullable = true)
    private UsuarioEntity profesor;
}
