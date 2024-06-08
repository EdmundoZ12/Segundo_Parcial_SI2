package com.backend.backend.Tipo_Carrera;

import com.backend.backend.Tipo_Carrera.DTO.DTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoCarrera_Service {

    private final TipoCarrera_Repository carreraRepository;

    public void createTip_Carrera(DTO dto) {
        if (carreraRepository.existsByNombre(dto.getNombre())) {
            throw new RuntimeException("El Tipo de Carrera ya existe");
        }

        TipoCarrera tipoCarrera = TipoCarrera.builder()
                .nombre(dto.getNombre())
                .build();

        carreraRepository.save(tipoCarrera);
    }

    public List<TipoCarrera> getAllTips_Carrera() {
        return carreraRepository.findAll();
    }
}
