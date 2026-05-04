package com.duoc.learningplatformvalidation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class UsuarioEntity {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El correo debe ser válido")
    @Column(unique = true)
    private String correo;

    @NotBlank(message = "La contraseña no puede estar vacía")
    private String contraseña;

    @Enumerated(EnumType.STRING)
    private Rol rol;
}
