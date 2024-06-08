package com.backend.backend.Modalidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Modalidad_Repository extends JpaRepository<Modalidad, Integer> {

    boolean existsByNombre(String nombre);
}
