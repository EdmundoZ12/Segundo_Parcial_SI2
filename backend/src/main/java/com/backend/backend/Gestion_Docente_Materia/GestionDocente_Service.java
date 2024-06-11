package com.backend.backend.Gestion_Docente_Materia;

import com.backend.backend.Docente.Docente;
import com.backend.backend.Docente.DocenteRepository;
import com.backend.backend.Gestion.DTO.DTO_Gestion_Request;
import com.backend.backend.Gestion.Gestion;
import com.backend.backend.Gestion.Gestion_Repository;
import com.backend.backend.Gestion_Docente_Materia.DTO.DTO_Asignar_Gestion_Docente;
import com.backend.backend.Gestion_Docente_Materia.DTO.DTO_Materias;
import com.backend.backend.Grupo.Grupo_Repository;
import com.backend.backend.Materia.Materia_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GestionDocente_Service {

    private final GestionDocente_Repository gestionDocenteRepository;
    private final DocenteRepository docenteRepository;
    private final Gestion_Repository gestionRepository;
    private final Materia_Repository materiaRepository;
    private final Grupo_Repository grupoRepository;

    public void createGestionDocente(DTO_Asignar_Gestion_Docente dtoAsignarGestionDocente) {

        if (dtoAsignarGestionDocente.getId_gestion() == null
                || dtoAsignarGestionDocente.getNro_registro() == null) {
            throw new RuntimeException("Faltan datos a Registrar");
        }

        Docente docente = docenteRepository.getReferenceById(dtoAsignarGestionDocente.getNro_registro());
        System.out.println("ESTE ES EL DOCENTEEEEEEEEEE");
        System.out.println(docente);
        List<DTO_Materias> materias = dtoAsignarGestionDocente.getMaterias();
        for (DTO_Materias materia : materias) {
            boolean exists = gestionDocenteRepository.existsByDocenteAndCodMateriaAndIdGrupoAndIdGestion(
                    docente,
                    materia.getCod_materia(),
                    materia.getId_grupo(),
                    dtoAsignarGestionDocente.getId_gestion()
            );

            if (exists) {
                continue;
            }

            GestioDocente gestioDocente = GestioDocente.builder()
                    .docente(docente)
                    .idGestion(dtoAsignarGestionDocente.getId_gestion())
                    .idGrupo(materia.getId_grupo())
                    .codMateria(materia.getCod_materia())
                    .build();

            System.out.println(gestioDocente);

            gestionDocenteRepository.save(gestioDocente);
        }


    }
}
