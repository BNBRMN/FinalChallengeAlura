package com.aluracursos.finalchallenge.foroalura.repository;

import com.aluracursos.finalchallenge.foroalura.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para manejar las operaciones CRUD de las entidades Respuesta.
 */
@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
}
