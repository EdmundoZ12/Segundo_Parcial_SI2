package com.backend.backend.Materia;

import com.backend.backend.Carrera.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Materia_Repository extends JpaRepository<Materia, String> {
    boolean existsByNombre(String nombre);

    Optional<Carrera> findByCod(String codigo);

    boolean existsByCod(String cod);
}
