package com.backend.backend.Gestion;

import com.backend.backend.Carrera.Carrera;
import com.backend.backend.Carrera.Carrera_Repository;
import com.backend.backend.Gestion.DTO.DTO_Carreras;
import com.backend.backend.Gestion.DTO.DTO_Gestion;
import com.backend.backend.Gestion.DTO.DTO_Gestion_Request;
import com.backend.backend.Gestion.DTO.DTO_Gestion_Response;
import com.backend.backend.GestionCarrera.GestionCarrera;
import com.backend.backend.GestionCarrera.GestionCarrera_Repository;
import com.backend.backend.Modalidad.Modalidad;
import com.backend.backend.Modalidad.Modalidad_Repository;
import com.backend.backend.Modalidad_Carrera.ModalidadCarrera;
import com.backend.backend.Modalidad_Carrera.ModalidadCarrera_Repository;
import com.backend.backend.Tipo_Carrera.TipoCarrera_Repository;
import com.backend.backend.Tipo_Periodo.TipoPeriodo;
import com.backend.backend.Tipo_Periodo.TipoPeriodo_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Gestion_Service {

    private final Gestion_Repository gestionRepository;
    private final ModalidadCarrera_Repository modalidadCarreraRepository;
    private final GestionCarrera_Repository gestionCarreraRepository;
    private final Carrera_Repository carreraRepository;
    private final Modalidad_Repository modalidadRepository;
    private final TipoCarrera_Repository tipoCarreraRepository;
    private final TipoPeriodo_Repository tipoPeriodoRepository;

    public void createGestion(DTO_Gestion_Request dtoGestionRequest) {

        if (dtoGestionRequest.getNombre() == null || dtoGestionRequest.getFecha_final() == null
                || dtoGestionRequest.getFecha_inicio() == null) {
            throw new RuntimeException("Faltan datos a Registrar");
        }

        if (gestionRepository.existsByNombre(dtoGestionRequest.getNombre())) {
            throw new RuntimeException("Ya existe una Gestion con este nombre");
        }
        TipoPeriodo tipoPeriodo = tipoPeriodoRepository.getReferenceById(dtoGestionRequest.getId_tperiodo());

        Gestion gestion = Gestion.builder()
                .nombre(dtoGestionRequest.getNombre())
                .fechaInicio(dtoGestionRequest.getFecha_inicio())
                .fechaFinal(dtoGestionRequest.getFecha_final())
                .tipoPeriodo(tipoPeriodo)
                .build();

        Gestion gestion1 = gestionRepository.save(gestion);

        List<ModalidadCarrera> modalidadCarreras = modalidadCarreraRepository.findAll();
        Integer id_gestion = gestion1.getId();
        for (ModalidadCarrera carrera : modalidadCarreras) {
            GestionCarrera gestionCarrera = GestionCarrera.builder()
                    .idGestion(id_gestion)
                    .idModalidad(carrera.getIdModalidad())
                    .codCarrera(carrera.getCodCarrera())
                    .build();
            gestionCarreraRepository.save(gestionCarrera);
        }
    }

    public DTO_Gestion_Response getGestion(Integer id) {
        Gestion gestion = gestionRepository.getReferenceById(id);
        List<GestionCarrera> gestionCarreras = gestionCarreraRepository.findAll();
        List<DTO_Carreras> carreras = new ArrayList<>();
        TipoPeriodo tipoPeriodo = gestion.getTipoPeriodo();

        for (GestionCarrera gestionCarrera : gestionCarreras) {
            if (gestionCarrera.getIdGestion() != id) {
                continue;
            }
            Carrera carrera = carreraRepository.getReferenceById(gestionCarrera.getCodCarrera());
            Modalidad modalidad = modalidadRepository.getReferenceById(gestionCarrera.getIdModalidad());

            DTO_Carreras dtoCarreras = DTO_Carreras.builder()
                    .cod_carrera(carrera.getCod())
                    .nombre_carrera(carrera.getNombre())
                    .id_modalidad(modalidad.getId())
                    .nombre_modalidad(modalidad.getNombre())
                    .id_tcarrera(tipoPeriodo.getId())
                    .nombre_tcarrera(tipoPeriodo.getNombre())
                    .build();

            carreras.add(dtoCarreras);
        }

        DTO_Gestion_Response dtoGestionResponse = DTO_Gestion_Response.builder()
                .id_gestion(gestion.getId())
                .nombre_gestion(gestion.getNombre())
                .fecha_inicio(gestion.getFechaInicio())
                .fecha_final(gestion.getFechaFinal())
                .carreras(carreras)
                .build();
        return dtoGestionResponse;
    }

    public List<DTO_Gestion> getAllGestiones() {
        List<Gestion> gestionCarreras = gestionRepository.findAll();
        List<DTO_Gestion> gestions = new ArrayList<>();
        for (Gestion gestion : gestionCarreras) {
            DTO_Gestion dtoGestion = DTO_Gestion.builder()
                    .id(gestion.getId())
                    .nombre(gestion.getNombre())
                    .fecha_inicio(gestion.getFechaInicio())
                    .fecha_final(gestion.getFechaFinal())
                    .id_tperiodo(gestion.getTipoPeriodo().getId())
                    .nombre_tperiodo(gestion.getTipoPeriodo().getNombre())
                    .build();
            gestions.add(dtoGestion);
        }

        return gestions;
    }
}
