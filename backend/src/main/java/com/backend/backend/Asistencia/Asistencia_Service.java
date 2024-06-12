package com.backend.backend.Asistencia;

import com.backend.backend.Asistencia.DTO.DTO_Asistencia;
import com.backend.backend.Docente.Docente;
import com.backend.backend.Docente.DocenteRepository;
import com.backend.backend.Gestion.DTO.DTO_Gestion;
import com.backend.backend.Gestion.Gestion_Service;
import com.backend.backend.Gestion_Docente_Materia.GestionDocente;
import com.backend.backend.Gestion_Docente_Materia.GestionDocente_Repository;
import com.backend.backend.Gestion_Docente_Materia.GestionDocente_Service;
import com.backend.backend.Horario.Horario;
import com.backend.backend.Horario.Horario_Repository;
import com.backend.backend.Tipo_Asistencia.TipoAsistencia;
import com.backend.backend.Tipo_Asistencia.TipoAsistencia_Repository;
import com.backend.backend.Zona_Horario.ZonaHoraria_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class Asistencia_Service {

    private final Horario_Repository horarioRepository;
    private final GestionDocente_Repository gestionDocenteRepository;
    private final Gestion_Service gestionService;
    private final DocenteRepository docenteRepository;
    private final TipoAsistencia_Repository tipoAsistenciaRepository;
    private final Asistencia_Repository asistenciaRepository;
    private final ZonaHoraria_Service zonaHorariaService;

    public void crearAsistencia(DTO_Asistencia dtoAsistencia) {
        DTO_Gestion gestion = gestionService.getLastGestion();

        if (dtoAsistencia.getCod_materia() == null || dtoAsistencia.getId_grupo() == null) {
            throw new RuntimeException("Faltan datos a Registrar");
        }
        Horario horario = horarioRepository.getReferenceById(dtoAsistencia.getId_horario());
        Docente docente = docenteRepository.getReferenceById(dtoAsistencia.getNro_registro());
        GestionDocente gestionDocente = gestionDocenteRepository.findByDocenteAndCodMateriaAndIdGrupoAndIdGestion(docente, dtoAsistencia.getCod_materia(), dtoAsistencia.getId_grupo(), gestion.getId());
        String dia = zonaHorariaService.obtenerDiaSemanaEnEspañol();
        LocalTime hora_actual = zonaHorariaService.obtenerHoraEnZonaHoraria();
//        String dia = "Lunes";
//        LocalTime hora_actual = LocalTime.parse("10:15", DateTimeFormatter.ofPattern("H:mm"));
        LocalTime horaHorarioMas15Min = horario.getHoraInicio().plusMinutes(15);
        Date fecha = zonaHorariaService.obtenerFecha();
        if (horario.getDia().equalsIgnoreCase(dia)) {
            if ((hora_actual.isBefore(horario.getHoraInicio()) || hora_actual.equals(horario.getHoraInicio())) ||
                    (hora_actual.isBefore(horaHorarioMas15Min) || hora_actual.equals(horaHorarioMas15Min))) {
                // Docente llegó dentro del margen de tiempo permitido antes o después del inicio del horario
                TipoAsistencia tipoAsistencia = tipoAsistenciaRepository.getReferenceById(1);

                Asistencia asistencia = Asistencia.builder()
                        .tipoAsistencia(tipoAsistencia)
                        .gestionDocente(gestionDocente)
                        .fecha(fecha)
                        .horaEntrada(hora_actual)
                        .motivo(dtoAsistencia.getMotivo())
                        .modalidad(dtoAsistencia.getModalidad())
                        .docente(docente)
                        .build();
                asistenciaRepository.save(asistencia);
            } else if (hora_actual.isBefore(horario.getHoraFin())) {
                // Docente llegó después de los 15 minutos pero antes de la hora final del horario
                TipoAsistencia tipoAsistencia = tipoAsistenciaRepository.getReferenceById(2);
                Asistencia asistencia = Asistencia.builder()
                        .tipoAsistencia(tipoAsistencia)
                        .gestionDocente(gestionDocente)
                        .fecha(fecha)
                        .horaEntrada(hora_actual)
                        .motivo(dtoAsistencia.getMotivo())
                        .modalidad(dtoAsistencia.getModalidad())
                        .docente(docente)
                        .build();
                asistenciaRepository.save(asistencia);
            } else if (hora_actual.isAfter(horario.getHoraFin()) || hora_actual.equals(horario.getHoraFin())) {
                // Estudiante llegó después de la hora final del horario
                TipoAsistencia tipoAsistencia = tipoAsistenciaRepository.getReferenceById(3);
                Asistencia asistencia = Asistencia.builder()
                        .tipoAsistencia(tipoAsistencia)
                        .gestionDocente(gestionDocente)
                        .fecha(fecha)
                        .horaEntrada(hora_actual)
                        .motivo(dtoAsistencia.getMotivo())
                        .modalidad(dtoAsistencia.getModalidad())
                        .docente(docente)
                        .build();
                asistenciaRepository.save(asistencia);
            }
        }

    }
}
