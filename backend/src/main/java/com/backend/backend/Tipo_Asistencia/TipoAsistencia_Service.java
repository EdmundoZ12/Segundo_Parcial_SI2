package com.backend.backend.Tipo_Asistencia;

import com.backend.backend.Tipo_Asistencia.DTO.DTO_TipAsistencia;
import com.backend.backend.Tipo_Periodo.DTO.DTO_TipPeriodo;
import com.backend.backend.Tipo_Periodo.TipoPeriodo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoAsistencia_Service {

    private final TipoAsistencia_Repository tipoAsistenciaRepository;

    public void createTipo_Asistencia(DTO_TipAsistencia dtoTipAsistencia) {
        if (tipoAsistenciaRepository.existsByNombre(dtoTipAsistencia.getNombre())) {
            throw new RuntimeException("El Tipo de Asistencia ya existe");
        }

        TipoAsistencia tipoAsistencia = TipoAsistencia.builder()
                .nombre(dtoTipAsistencia.getNombre())
                .build();
        tipoAsistenciaRepository.save(tipoAsistencia);

    }

    public List<TipoAsistencia> getAllTipos_Asistencia() {
        return tipoAsistenciaRepository.findAll();
    }
}
