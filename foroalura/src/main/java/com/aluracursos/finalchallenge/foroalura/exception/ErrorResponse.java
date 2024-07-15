package com.aluracursos.finalchallenge.foroalura.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Clase para representar las respuestas de error en la aplicación.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDateTime timestamp; // Momento en que ocurre el error
    private String message;          // Mensaje descriptivo del error
    private String details;          // Detalles adicionales del error
    private HttpStatus status;       // Código de estado HTTP

}
