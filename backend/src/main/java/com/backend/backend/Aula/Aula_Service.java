package com.backend.backend.Aula;

import com.backend.backend.Aula.DTO.DTO_Aula;
import com.backend.backend.Aula.DTO.DTO_Aulas_Modulo;
import com.backend.backend.Materia.DTO.DTO_Materias_Grupo;
import com.backend.backend.Materia.Materia;
import com.backend.backend.Materia_Grupo.MateriaGrupo;
import com.backend.backend.Modulo.DTO.DTO_Modulo;
import com.backend.backend.Modulo.Modulo;
import com.backend.backend.Modulo.Modulo_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Aula_Service {

    private final Aula_Repository aulaRepository;
    private final Modulo_Repository moduloRepository;

    public void createAula(DTO_Aula dtoAula) {
        if (aulaRepository.existsByNro(dtoAula.getNro())) {
            throw new RuntimeException("El Numero de Aula ya existe en el Modulo");
        }
        Modulo modulo = moduloRepository.getReferenceById(dtoAula.getId_modulo());
        Aula aula = Aula.builder()
                .nro(dtoAula.getNro())
                .modulo(modulo)
                .build();
        aulaRepository.save(aula);
    }

    public List<Aula> getAllAulas() {
        return aulaRepository.findAll();
    }

    public List<DTO_Aulas_Modulo> getAllAulas_Modulo() {
        List<Aula> aulas = getAllAulas();
        List<DTO_Aulas_Modulo> aulasModulos = new ArrayList<>();

        for (Aula aula : aulas) {
            Modulo modulo = aula.getModulo();
            String nombreAulaModulo = "Aula nro: " + aula.getNro().toString() + " - " + modulo.getNombre();
            DTO_Aulas_Modulo dtoAulasModulo = DTO_Aulas_Modulo.builder()
                    .id_aula(aula.getId())
                    .id_modulo(modulo.getId())
                    .nombre(nombreAulaModulo)
                    .build();

            aulasModulos.add(dtoAulasModulo);
        }

        return aulasModulos;
    }

}
