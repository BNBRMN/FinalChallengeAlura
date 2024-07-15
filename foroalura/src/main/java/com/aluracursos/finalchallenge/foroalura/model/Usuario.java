package com.aluracursos.finalchallenge.foroalura.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío.")
    private String nombre;

    @Email(message = "Debe proporcionar una dirección de correo electrónico válida.")
    @NotBlank(message = "El correo electrónico no puede estar vacío.")
    private String email;
}
