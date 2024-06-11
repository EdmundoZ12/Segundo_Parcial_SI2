package com.backend.backend.Gestion_Docente_Materia;

import com.backend.backend.Docente.Docente;
import com.backend.backend.Docente.DocenteRepository;
import com.backend.backend.Gestion.DTO.DTO_Gestion_Request;
import com.backend.backend.Gestion.Gestion;
import com.backend.backend.Gestion.Gestion_Repository;
import com.backend.backend.Gestion_Docente_Materia.DTO.DTO_Asignar_Gestion_Docente;
import com.backend.backend.Gestion_Docente_Materia.DTO.DTO_Materias;
import com.backend.backend.Grupo.Grupo;
import com.backend.backend.Grupo.Grupo_Repository;
import com.backend.backend.Horario.Horario;
import com.backend.backend.Horario.Horario_Service;
import com.backend.backend.Materia.Materia;
import com.backend.backend.Materia.Materia_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GestionDocente_Service {

    private final GestionDocente_Repository gestionDocenteRepository;
    private final DocenteRepository docenteRepository;
    private final Gestion_Repository gestionRepository;
    private final Materia_Repository materiaRepository;
    private final Grupo_Repository grupoRepository;
    private final Horario_Service horarioService;

    public void createGestionDocente(DTO_Asignar_Gestion_Docente dtoAsignarGestionDocente) {

        if (dtoAsignarGestionDocente.getId_gestion() == null
                || dtoAsignarGestionDocente.getNro_registro() == null) {
            throw new RuntimeException("Faltan datos a Registrar");
        }

        Docente docente = docenteRepository.getReferenceById(dtoAsignarGestionDocente.getNro_registro());
        System.out.println("ESTE ES EL DOCENTEEEEEEEEEE");
        System.out.println(docente);
        List<DTO_Materias> materias = dtoAsignarGestionDocente.getMaterias();
        for (DTO_Materias materia : materias) {
            boolean exists = gestionDocenteRepository.existsByDocenteAndCodMateriaAndIdGrupoAndIdGestion(
                    docente,
                    materia.getCod_materia(),
                    materia.getId_grupo(),
                    dtoAsignarGestionDocente.getId_gestion()
            );

            if (exists) {
                continue;
            }

            GestioDocente gestioDocente = GestioDocente.builder()
                    .docente(docente)
                    .idGestion(dtoAsignarGestionDocente.getId_gestion())
                    .idGrupo(materia.getId_grupo())
                    .codMateria(materia.getCod_materia())
                    .build();

            System.out.println(gestioDocente);

            gestionDocenteRepository.save(gestioDocente);
        }
    }

    public List<DTO_Materias> getMateriasByDocenteAndLatestGestion(String nroRegistro) {
        Gestion latestGestion = gestionRepository.findLastGestion();
        Docente docente = docenteRepository.findById(nroRegistro).orElseThrow(() -> new RuntimeException("Docente no encontrado"));

        List<GestioDocente> gestionDocenteList = gestionDocenteRepository.findByDocenteAndIdGestion(docente, latestGestion.getId());

        List<DTO_Materias> materias = new ArrayList<>();
        for (GestioDocente gestionDocente : gestionDocenteList) {
            Materia materia = materiaRepository.getReferenceById(gestionDocente.getCodMateria());
            Grupo grupo = grupoRepository.getReferenceById(gestionDocente.getIdGrupo());
            DTO_Materias dtoMateriasGrupo = DTO_Materias.builder()
                    .cod_materia(materia.getCod())
                    .nombre_materia(materia.getNombre())
                    .id_grupo(grupo.getId())
                    .nombre_grupo(grupo.getNombre())
                    .build();
            materias.add(dtoMateriasGrupo);
        }
        return materias;
    }

    public String obtenerDiaSemanaEnEspañol() {
        // Mapeo de nombres de días en inglés a español
        Map<String, String> dayTranslations = new HashMap<>();
        dayTranslations.put("MONDAY", "Lunes");
        dayTranslations.put("TUESDAY", "Martes");
        dayTranslations.put("WEDNESDAY", "Miércoles");
        dayTranslations.put("THURSDAY", "Jueves");
        dayTranslations.put("FRIDAY", "Viernes");
        dayTranslations.put("SATURDAY", "Sábado");
        dayTranslations.put("SUNDAY", "Domingo");

        // Obtener la zona horaria UTC-04:00
        ZoneId zoneId = ZoneId.of("UTC-04:00");

        // Obtener la fecha actual en la zona horaria especificada
        LocalDate currentDate = LocalDate.now(zoneId);

        // Obtener el día de la semana actual
        DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();

        // Convertir el día de la semana a texto en inglés
        String dayOfWeekEnglish = currentDayOfWeek.toString();


        // Obtener el nombre del día en español a partir del mapeo
        return dayTranslations.get(dayOfWeekEnglish);
    }

    public LocalTime obtenerHoraEnZonaHoraria() {
        // Obtener la hora actual en la zona horaria UTC-04:00
        return LocalTime.now(ZoneId.of("UTC-04:00"));
    }

    public List<Horario> getHorariosCerca(String nroRegistro) {
        List<DTO_Materias> materias = getMateriasByDocenteAndLatestGestion(nroRegistro);
        List<Horario> horarioList = new ArrayList<>();
//        String dia = obtenerDiaSemanaEnEspañol();
//        LocalTime hora_inicio = obtenerHoraEnZonaHoraria();
        String dia = "Lunes";
        LocalTime hora_inicio = LocalTime.parse("10:14", DateTimeFormatter.ofPattern("H:mm"));
        System.out.println(obtenerHoraEnZonaHoraria());
        for (DTO_Materias materia : materias) {
            List<Horario> horarios = horarioService.getHorariosPorMateriaYGrupo(materia.getCod_materia(), materia.getId_grupo());
            for (Horario horario : horarios) {
                LocalTime horaHorarioMenos30Min = horario.getHoraInicio().minusMinutes(30);
                LocalTime horaHorarioMas15Min = horario.getHoraInicio().plusMinutes(15);

                // Verificar si la hora actual está dentro del rango de media hora antes y 15 minutos después del horario
                if (horario.getDia().equalsIgnoreCase(dia) && ((hora_inicio.equals(horario.getHoraInicio()) ||
                        hora_inicio.equals(horaHorarioMenos30Min) || (hora_inicio.isAfter(horaHorarioMenos30Min) &&
                        hora_inicio.isBefore(horario.getHoraInicio()))) || (hora_inicio.isAfter(horario.getHoraInicio()) &&
                        hora_inicio.isBefore(horaHorarioMas15Min)))) {
                    horarioList.add(horario);
                }
            }
        }
        return horarioList;
    }
}
