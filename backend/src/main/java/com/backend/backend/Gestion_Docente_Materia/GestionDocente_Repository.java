package com.backend.backend.Gestion_Docente_Materia;

import com.backend.backend.Docente.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestionDocente_Repository extends JpaRepository<GestioDocente,GestionDocenteID> {

    boolean existsByDocenteAndCodMateriaAndIdGrupoAndIdGestion(Docente docente, String codMateria, Integer idGrupo, Integer idGestion);
}
