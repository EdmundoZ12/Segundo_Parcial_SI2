package com.backend.backend.Modalidad_Carrera;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModalidadCarrera_Repository extends JpaRepository<ModalidadCarrera, ModalidadCarreraId> {

    Optional<ModalidadCarrera> findByCodCarreraAndIdModalidad(String codCarrera, Integer idModalidad);
}
