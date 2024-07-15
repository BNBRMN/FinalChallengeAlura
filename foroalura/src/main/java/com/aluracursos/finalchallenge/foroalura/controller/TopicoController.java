package com.aluracursos.finalchallenge.foroalura.controller;

import com.aluracursos.finalchallenge.foroalura.model.Topico;
import com.aluracursos.finalchallenge.foroalura.repository.TopicoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository repository;

    public TopicoController(TopicoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Topico> crearTopico(@RequestBody @Valid Topico topico) {
        topico.setFechaCreacion(LocalDateTime.now());
        Topico savedTopico = repository.save(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTopico);
    }

    @GetMapping
    public List<Topico> listarTopicos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopico(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @RequestBody @Valid Topico nuevoTopico) {
        return repository.findById(id)
                .map(topicoExistente -> {
                    topicoExistente.setTitulo(nuevoTopico.getTitulo());
                    topicoExistente.setMensaje(nuevoTopico.getMensaje());
                    topicoExistente.setStatus(nuevoTopico.getStatus());
                    topicoExistente.setAutor(nuevoTopico.getAutor());
                    topicoExistente.setCurso(nuevoTopico.getCurso());
                    return ResponseEntity.ok(repository.save(topicoExistente));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarTopico(@PathVariable Long id) {
        return repository.findById(id)
                .map(topico -> {
                    repository.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
