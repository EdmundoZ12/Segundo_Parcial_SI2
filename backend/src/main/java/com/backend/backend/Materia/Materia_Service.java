package com.backend.backend.Materia;

import com.backend.backend.Materia.DTO.DTO_Materia;
import com.backend.backend.Materia.DTO.DTO_Materias_Grupo;
import com.backend.backend.Materia_Grupo.MateriaGrupo;
import com.backend.backend.Modalidad.DTO.DTO_Modalidad;
import com.backend.backend.Modalidad.Modalidad;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Materia_Service {

    private final Materia_Repository materiaRepository;

    public void createMateria(DTO_Materia dtoMateria) {
        if (materiaRepository.existsByNombre(dtoMateria.getNombre()) || materiaRepository.existsByCod(dtoMateria.getCod())) {
            throw new RuntimeException("Campos repetidos");
        }

        Materia materia = Materia.builder()
                .cod(dtoMateria.getCod())
                .nombre(dtoMateria.getNombre())
                .build();
        materiaRepository.save(materia);
    }

    public List<Materia> getAllMaterias() {
        return materiaRepository.findAll();
    }

    public List<DTO_Materias_Grupo> getAllMateriasGrupo() {
        List<Materia> materias = getAllMaterias();
        List<DTO_Materias_Grupo> materiasGrupos = new ArrayList<>();

        for (Materia materia : materias) {
            List<MateriaGrupo> grupos = materia.getMateriaGrupos();
            List<DTO_Materias_Grupo> dtos = grupos.stream()
                    .map(grupo -> DTO_Materias_Grupo.builder()
                            .cod_materia(materia.getCod())
                            .id_grupo(grupo.getIdGrupo())
                            .nombre(materia.getNombre() + " " + grupo.getGrupo().getNombre())
                            .build())
                    .collect(Collectors.toList());

            materiasGrupos.addAll(dtos);
        }

        return materiasGrupos;
    }
}
