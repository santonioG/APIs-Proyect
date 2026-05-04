package com.duoc.learningplatformvalidation.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "inscripcion")
@Getter
@Setter
public class InscripcionEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private CursoEntity curso;

    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false)
    private UsuarioEntity alumno;
    
    @Column(name = "fecha_inscripcion")
    private LocalDate fechaInscripcion;

    @PrePersist
    protected void onCreate() {
        this.fechaInscripcion = LocalDate.now(); //Anotacion de springboot para que se ejecute antes de guardar 
                                                    // la entidad en la base de datos, asignando la fecha actual a fechaInscripcion.
    }
}
