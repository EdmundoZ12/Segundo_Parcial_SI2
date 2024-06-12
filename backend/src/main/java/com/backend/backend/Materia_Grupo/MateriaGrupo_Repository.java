package com.backend.backend.Materia_Grupo;

import com.backend.backend.Modalidad_Carrera.ModalidadCarrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MateriaGrupo_Repository extends JpaRepository<MateriaGrupo, MateriaGrupoID> {
    Optional<MateriaGrupo> findByCodMateriaAndIdGrupo(String codMateria, Integer idGrupo);
}
