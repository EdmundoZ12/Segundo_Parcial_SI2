package com.backend.backend.Rol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rol_Repository extends JpaRepository<Rol, Integer> {
    boolean existsByNombre(String nombre);
}
