package com.backend.backend.Aula;

import com.backend.backend.Aula.DTO.DTO_Aula;
import com.backend.backend.Modulo.DTO.DTO_Modulo;
import com.backend.backend.Modulo.Modulo;
import com.backend.backend.Modulo.Modulo_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
