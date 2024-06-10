package com.backend.backend.Materia;

import com.backend.backend.Materia.DTO.DTO_Materia;
import com.backend.backend.Modalidad.DTO.DTO_Modalidad;
import com.backend.backend.Modalidad.Modalidad;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
