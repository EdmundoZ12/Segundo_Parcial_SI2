package com.backend.backend.GestionCarrera;

import com.backend.backend.Modalidad_Carrera.ModalidadCarrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GestionCarrera_Repository extends JpaRepository<GestionCarrera, GestionCarreraID> {

    Optional<GestionCarrera> findByCodCarreraAndIdModalidad(String codCarrera, Integer idModalidad);

}
