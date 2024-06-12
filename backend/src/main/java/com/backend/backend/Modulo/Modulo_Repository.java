package com.backend.backend.Modulo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Modulo_Repository extends JpaRepository<Modulo, Integer> {
    boolean existsByNombre(String nombre);
}
