package com.backend.backend.Tipo_Asistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAsistencia_Repository extends JpaRepository<TipoAsistencia, Integer> {
    boolean existsByNombre(String nombre);
}
