package com.backend.backend.Carrera;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Carrera_Repository extends JpaRepository<Carrera, String> {

    boolean existsByNombre(String nombre);

    Optional<Carrera> findByCod(String codigo);

    boolean existsByCod(String cod);
}
