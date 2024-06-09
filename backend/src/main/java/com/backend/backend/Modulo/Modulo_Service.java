package com.backend.backend.Modulo;

import com.backend.backend.Aula.Aula;
import com.backend.backend.Aula.Aula_Repository;
import com.backend.backend.Modulo.DTO.DTO_Modulo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Modulo_Service {

    private final Modulo_Repository moduloRepository;
    private final Aula_Repository aulaRepository;

    public void createModulo(DTO_Modulo dtoModulo) {
        if (moduloRepository.existsByNombre(dtoModulo.getNombre())) {
            throw new RuntimeException("El Nombre del Modulo ya existe");
        }

        Modulo modulo = Modulo.builder()
                .nombre(dtoModulo.getNombre())
                .ubicacion(dtoModulo.getUbicacion())
                .build();
        moduloRepository.save(modulo);
    }

    public List<Modulo> getAllModulos() {
        return moduloRepository.findAll();
    }

    public List<Aula> getAulasByModuloId(Integer moduloId) {
        Modulo modulo = moduloRepository.findById(moduloId)
                .orElseThrow(() -> new RuntimeException("Modulo no encontrado con ID: " + moduloId));
        List<Aula> aulas = aulaRepository.findByModulo(modulo);
        return aulas;
    }
}
