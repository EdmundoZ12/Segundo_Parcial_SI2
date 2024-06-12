package com.backend.backend.Gest_Doc_Mate;

import com.backend.backend.Docente.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GestionDocente_Repository extends JpaRepository<GestionDocente, GestionDocenteID> {

    boolean existsByDocenteAndCodMateriaAndIdGrupoAndIdGestion(Docente docente, String codMateria, Integer idGrupo, Integer idGestion);

    List<GestionDocente> findByDocenteAndIdGestion(Docente docente, Integer idGestion);

    boolean existsByCodMateriaAndIdGrupoAndIdGestion(String codMateria, Integer idGrupo, Integer idGestion);

    GestionDocente findByDocenteAndCodMateriaAndIdGrupoAndIdGestion(Docente docente, String codMateria, Integer idGrupo, Integer idGestion);
}
