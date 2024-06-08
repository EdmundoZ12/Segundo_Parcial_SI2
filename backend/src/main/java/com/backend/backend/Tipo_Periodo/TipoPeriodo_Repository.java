package com.backend.backend.Tipo_Periodo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPeriodo_Repository extends JpaRepository<TipoPeriodo, Integer> {

    boolean existsByNombre(String nombre);
}
