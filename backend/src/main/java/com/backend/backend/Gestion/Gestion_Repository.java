package com.backend.backend.Gestion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Gestion_Repository extends JpaRepository<Gestion, Integer> {

    boolean existsByNombre(String nombre);

    Optional<Gestion> findById(Integer id);

    boolean existsById(Integer id);
}
