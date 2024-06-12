package com.backend.backend.Tipo_Periodo;

import com.backend.backend.Tipo_Periodo.DTO.DTO_TipPeriodo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoPeriodo_Service {

    private final TipoPeriodo_Repository periodoRepository;

    public TipoPeriodo createTipo_Periodo(DTO_TipPeriodo tipPeriodo) {
        if (periodoRepository.existsByNombre(tipPeriodo.getNombre())) {
            throw new RuntimeException("El Tipo de Periodo ya existe");
        }

        TipoPeriodo tipoPeriodo = TipoPeriodo.builder()
                .nombre(tipPeriodo.getNombre())
                .build();

        return periodoRepository.save(tipoPeriodo);
    }

    public List<TipoPeriodo> getAllTipos_Periodo() {
        return periodoRepository.findAll();
    }
}
