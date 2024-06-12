package com.backend.backend.Grupo;

import com.backend.backend.Carrera.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Grupo_Repository extends JpaRepository<Grupo, Integer> {
    boolean existsByNombre(String nombre);

    Optional<Grupo> findById(Integer id);

}
