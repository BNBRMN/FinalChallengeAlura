package com.aluracursos.finalchallenge.foroalura.controller;

import com.aluracursos.finalchallenge.foroalura.model.Respuesta;
import com.aluracursos.finalchallenge.foroalura.repository.RespuestaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    private final RespuestaRepository repository;

    public RespuestaController(RespuestaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Respuesta> crearRespuesta(@RequestBody @Valid Respuesta respuesta) {
        Respuesta savedRespuesta = repository.save(respuesta);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRespuesta);
    }

    @GetMapping
    public List<Respuesta> listarRespuestas() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerRespuesta(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Respuesta> actualizarRespuesta(@PathVariable Long id, @RequestBody @Valid Respuesta nuevaRespuesta) {
        return repository.findById(id)
                .map(respuestaExistente -> {
                    respuestaExistente.setMensaje(nuevaRespuesta.getMensaje());
                    respuestaExistente.setAutor(nuevaRespuesta.getAutor());
                    return ResponseEntity.ok(repository.save(respuestaExistente));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarRespuesta(@PathVariable Long id) {
        return repository.findById(id)
                .map(respuesta -> {
                    repository.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
