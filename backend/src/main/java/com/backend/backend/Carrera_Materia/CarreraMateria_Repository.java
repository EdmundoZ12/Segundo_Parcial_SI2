package com.backend.backend.Carrera_Materia;

import com.backend.backend.Modalidad_Carrera.ModalidadCarrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarreraMateria_Repository extends JpaRepository<CarreraMateria, CarreraMateriID> {
    Optional<CarreraMateria> findByCodCarreraAndCodCarrera(String codCarrera, String codMateria);
}
