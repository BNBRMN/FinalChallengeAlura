package com.aluracursos.finalchallenge.foroalura.repository;

import com.aluracursos.finalchallenge.foroalura.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para manejar las operaciones CRUD para la entidad Topico.
 */
@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
