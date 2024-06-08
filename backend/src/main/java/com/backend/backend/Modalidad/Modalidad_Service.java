package com.backend.backend.Modalidad;

import com.backend.backend.Modalidad.DTO.DTO_Modalidad;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Modalidad_Service {

    private final Modalidad_Repository modalidadRepository;

    public void createModalidad(DTO_Modalidad dtoModalidad) {
        if (modalidadRepository.existsByNombre(dtoModalidad.getNombre())) {
            throw new RuntimeException("La Modalidad ya Existe");
        }

        Modalidad modalidad = Modalidad.builder()
                .nombre(dtoModalidad.getNombre())
                .build();
        modalidadRepository.save(modalidad);
    }

    public List<Modalidad> getAllModalidades() {
        return modalidadRepository.findAll();
    }
}
