package com.backend.backend.Tipo_Carrera;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCarrera_Repository extends JpaRepository<TipoCarrera, Integer> {

    boolean existsByNombre(String nombre);

}
