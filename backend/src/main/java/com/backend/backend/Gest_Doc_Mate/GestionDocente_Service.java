package com.backend.backend.Gest_Doc_Mate;

import com.backend.backend.Asistencia.Asistencia;
import com.backend.backend.Asistencia.Asistencia_Repository;
import com.backend.backend.Asistencia.Asistencia_Service;
import com.backend.backend.Asistencia.DTO.DTO_Asistencia;
import com.backend.backend.Docente.Docente;
import com.backend.backend.Docente.DocenteRepository;
import com.backend.backend.Gest_Doc_Mate.DTO.DTO_AsistenciaDocente;
import com.backend.backend.Gestion.Gestion;
import com.backend.backend.Gestion.Gestion_Repository;
import com.backend.backend.Gest_Doc_Mate.DTO.DTO_Asignar_Gestion_Docente;
import com.backend.backend.Gest_Doc_Mate.DTO.DTO_Horarios_Cercas;
import com.backend.backend.Gest_Doc_Mate.DTO.DTO_Materias;
import com.backend.backend.Grupo.Grupo;
import com.backend.backend.Grupo.Grupo_Repository;
import com.backend.backend.Horario.Horario;
import com.backend.backend.Horario.Horario_Service;
import com.backend.backend.Materia.Materia;
import com.backend.backend.Materia.Materia_Repository;
import com.backend.backend.Zona_Horario.ZonaHoraria_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;

@Service
@RequiredArgsConstructor
public class GestionDocente_Service {

    private final GestionDocente_Repository gestionDocenteRepository;
    private final DocenteRepository docenteRepository;
    private final Gestion_Repository gestionRepository;
    private final Materia_Repository materiaRepository;
    private final Grupo_Repository grupoRepository;
    private final Horario_Service horarioService;
    private final Asistencia_Repository asistenciaRepository;
    private final Asistencia_Service asistenciaService;
    private final ZonaHoraria_Service zonaHorariaService;

    public void createGestionDocente(DTO_Asignar_Gestion_Docente dtoAsignarGestionDocente) {

        if (dtoAsignarGestionDocente.getId_gestion() == null
                || dtoAsignarGestionDocente.getNro_registro() == null) {
            throw new RuntimeException("Faltan datos a Registrar");
        }

        Docente docente = docenteRepository.getReferenceById(dtoAsignarGestionDocente.getNro_registro());
        List<DTO_Materias> materias = dtoAsignarGestionDocente.getMaterias();
        for (DTO_Materias materia : materias) {
            boolean exists = gestionDocenteRepository.existsByCodMateriaAndIdGrupoAndIdGestion(
                    materia.getCod_materia(),
                    materia.getId_grupo(),
                    dtoAsignarGestionDocente.getId_gestion()
            );

            if (exists) {
                continue;
            }

            GestionDocente gestioDocente = GestionDocente.builder()
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

        List<GestionDocente> gestionDocenteList = gestionDocenteRepository.findByDocenteAndIdGestion(docente, latestGestion.getId());

        List<DTO_Materias> materias = new ArrayList<>();
        for (GestionDocente gestionDocente : gestionDocenteList) {
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


    public List<DTO_Horarios_Cercas> getHorariosCerca(String nroRegistro) {
        List<DTO_Materias> materias = getMateriasByDocenteAndLatestGestion(nroRegistro);
        List<DTO_Horarios_Cercas> horarioList = new ArrayList<>();
        Gestion gestion = gestionRepository.findLastGestion();
        String dia = zonaHorariaService.obtenerDiaSemanaEnEspañol();
        LocalTime hora_inicio = zonaHorariaService.obtenerHoraEnZonaHoraria();
        System.out.println(dia);
        Date fecha = zonaHorariaService.obtenerFecha();
//        String dia = "Lunes";
//        LocalTime hora_inicio = LocalTime.parse("11:29", DateTimeFormatter.ofPattern("H:mm"));
        for (DTO_Materias materia : materias) {
            List<Horario> horarios = horarioService.getHorariosPorMateriaYGrupo(materia.getCod_materia(), materia.getId_grupo());
            for (Horario horario : horarios) {
                LocalTime horaHorarioMenos30Min = horario.getHoraInicio().minusMinutes(30);
                if (!asistenciaRepository.existsByFechaAndGestionDocente_Docente_NroRegistroAndGestionDocente_CodMateriaAndGestionDocente_IdGrupoAndGestionDocente_IdGestion(fecha,
                        nroRegistro, materia.getCod_materia(), materia.getId_grupo(), gestion.getId())) {
                    // Verificar si la hora actual está dentro del rango de media hora antes y 15 minutos después del horario
                    if (horario.getDia().equalsIgnoreCase(dia) && ((hora_inicio.equals(horario.getHoraInicio()) ||
                            hora_inicio.equals(horaHorarioMenos30Min) || (hora_inicio.isAfter(horaHorarioMenos30Min)
                            && hora_inicio.isBefore(horario.getHoraInicio()))) || (hora_inicio.isAfter(horario.getHoraInicio())
                            && hora_inicio.isBefore(horario.getHoraFin())))) {
                        String nombre = materia.getNombre_materia() + " Grupo: " + materia.getNombre_grupo();
                        DTO_Horarios_Cercas dtoHorariosCercas = DTO_Horarios_Cercas.builder()
                                .nombre(nombre)
                                .id_horario(horario.getId())
                                .id_grupo(materia.getId_grupo())
                                .cod_materia(materia.getCod_materia())
                                .horaInicio(horario.getHoraInicio())
                                .horaFin(horario.getHoraFin())
                                .dia(horario.getDia())
                                .build();
                        horarioList.add(dtoHorariosCercas);
                    } else if (hora_inicio.isAfter(horario.getHoraFin()) || hora_inicio.equals(horario.getHoraFin())) {
                        DTO_Asistencia dtoAsistencia = DTO_Asistencia.builder()
                                .id_horario(horario.getId())
                                .cod_materia(materia.getCod_materia())
                                .nro_registro(nroRegistro)
                                .id_grupo(materia.getId_grupo())
                                .build();

                        asistenciaService.crearAsistencia(dtoAsistencia);

                    }
                }

            }
        }
        return horarioList;
    }

    public List<DTO_AsistenciaDocente> asistenciaDocente(String nroRegistro) {
        List<Asistencia> asistencias = asistenciaRepository.findByTipoAsistencia_IdAndDocente_NroRegistro(1, nroRegistro);
        List<DTO_AsistenciaDocente> lista = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            String nombre = asistencia.getGestionDocente().getMateriaGrupo().getMateria().getNombre() + " grupo: " + asistencia.getGestionDocente().getMateriaGrupo().getGrupo().getNombre();
            DTO_AsistenciaDocente dtoAsistenciaDocente = DTO_AsistenciaDocente.builder()
                    .nombre_materia(nombre)
                    .hora(asistencia.getHoraEntrada())
                    .fecha(asistencia.getFecha())
                    .motivo(asistencia.getMotivo())
                    .modalidad(asistencia.getModalidad())
                    .build();
            lista.add(dtoAsistenciaDocente);
        }

        return  lista;
    }

    public List<DTO_AsistenciaDocente> faltasDocente(String nroRegistro) {
        List<Asistencia> asistencias = asistenciaRepository.findByTipoAsistencia_IdAndDocente_NroRegistro(3, nroRegistro);
        List<DTO_AsistenciaDocente> lista = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            String nombre = asistencia.getGestionDocente().getMateriaGrupo().getMateria().getNombre() + " grupo: " + asistencia.getGestionDocente().getMateriaGrupo().getGrupo().getNombre();
            DTO_AsistenciaDocente dtoAsistenciaDocente = DTO_AsistenciaDocente.builder()
                    .nombre_materia(nombre)
                    .hora(asistencia.getHoraEntrada())
                    .fecha(asistencia.getFecha())
                    .motivo(asistencia.getMotivo())
                    .modalidad(asistencia.getModalidad())
                    .build();
            lista.add(dtoAsistenciaDocente);
        }

        return  lista;
    }

    public List<DTO_AsistenciaDocente> retrasosDocente(String nroRegistro) {
        List<Asistencia> asistencias = asistenciaRepository.findByTipoAsistencia_IdAndDocente_NroRegistro(2, nroRegistro);
        List<DTO_AsistenciaDocente> lista = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            String nombre = asistencia.getGestionDocente().getMateriaGrupo().getMateria().getNombre() + " grupo: " + asistencia.getGestionDocente().getMateriaGrupo().getGrupo().getNombre();
            DTO_AsistenciaDocente dtoAsistenciaDocente = DTO_AsistenciaDocente.builder()
                    .nombre_materia(nombre)
                    .hora(asistencia.getHoraEntrada())
                    .fecha(asistencia.getFecha())
                    .motivo(asistencia.getMotivo())
                    .modalidad(asistencia.getModalidad())
                    .build();
            lista.add(dtoAsistenciaDocente);
        }

        return  lista;
    }

    public List<DTO_AsistenciaDocente> licenciasDocente(String nroRegistro) {
        List<Asistencia> asistencias = asistenciaRepository.findByTipoAsistencia_IdAndDocente_NroRegistro(4, nroRegistro);
        List<DTO_AsistenciaDocente> lista = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            String nombre = asistencia.getGestionDocente().getMateriaGrupo().getMateria().getNombre() + " grupo: " + asistencia.getGestionDocente().getMateriaGrupo().getGrupo().getNombre();
            DTO_AsistenciaDocente dtoAsistenciaDocente = DTO_AsistenciaDocente.builder()
                    .nombre_materia(nombre)
                    .hora(asistencia.getHoraEntrada())
                    .fecha(asistencia.getFecha())
                    .motivo(asistencia.getMotivo())
                    .modalidad(asistencia.getModalidad())
                    .build();
            lista.add(dtoAsistenciaDocente);
        }

        return  lista;
    }


}
