package com.backend.backend.Horario;

import com.backend.backend.Aula.Aula;
import com.backend.backend.Aula.Aula_Repository;
import com.backend.backend.Horario.DTO.DTO_Horario;
import com.backend.backend.Horario.DTO.DTO_Horario_Create;
import com.backend.backend.Horario.DTO.DTO_HorariosResponse;
import com.backend.backend.Materia_Grupo.MateriaGrupo;
import com.backend.backend.Materia_Grupo.MateriaGrupo_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Horario_Service {

    private final Horario_Repository horarioRepository;
    private final Aula_Repository aulaRepository;
    private final MateriaGrupo_Repository materiaGrupoRepository;

    public void crearHorarios(DTO_Horario_Create dtoHorarioCreate) {

        if (dtoHorarioCreate.getCod_materia() == null || dtoHorarioCreate.getId_grupo() == null) {
            throw new RuntimeException("Faltan datos a Registrar");
        }

        Optional<MateriaGrupo> materiaGrupoOpt = materiaGrupoRepository.findByCodMateriaAndIdGrupo(dtoHorarioCreate.getCod_materia(), dtoHorarioCreate.getId_grupo());
        MateriaGrupo materiaGrupo;

        if (materiaGrupoOpt.isEmpty()) {
            materiaGrupo = MateriaGrupo.builder()
                    .idGrupo(dtoHorarioCreate.getId_grupo())
                    .codMateria(dtoHorarioCreate.getCod_materia())
                    .build();
            materiaGrupoRepository.save(materiaGrupo);
        } else {
            materiaGrupo = materiaGrupoOpt.get();
        }

        for (DTO_Horario horarios : dtoHorarioCreate.getHorarios()) {

            Aula aula = aulaRepository.getReferenceById(horarios.getId_aula());
            if (horarioRepository.existsByAulaAndDiaAndHoraInicioAndHoraFinAndMateriaGrupo(aula, horarios.getDia(), horarios.getHora_inicio(), horarios.getHora_fin(), materiaGrupo)) {
                // Si ya existe un horario para la misma materia, grupo, aula, día y horas, continuar con la próxima iteración
                System.out.println("Horario ya existente en el aula para esta materia, grupo, día y horas.");
                continue;
            }
            Horario horario = Horario.builder()
                    .dia(horarios.getDia())
                    .horaInicio(horarios.getHora_inicio())
                    .horaFin(horarios.getHora_fin())
                    .aula(aula)
                    .materiaGrupo(materiaGrupo)
                    .build();
            horarioRepository.save(horario);
        }

    }

    public List<Horario> getHorariosPorMateriaYGrupo(String codMateria, Integer idGrupo) {
        return horarioRepository.findByMateriaGrupo_CodMateriaAndMateriaGrupo_IdGrupo(codMateria, idGrupo);
    }

    public List<DTO_HorariosResponse> getHorariosMateriaGrupo(String codMateria, Integer idGrupo) {
        List<Horario> horarios = horarioRepository.findByMateriaGrupo_CodMateriaAndMateriaGrupo_IdGrupo(codMateria, idGrupo);
        List<DTO_HorariosResponse> responseList = new ArrayList<>();
        for (Horario horario : horarios) {
            String nombreAula =horario.getAula().getNro().toString()+"-" + horario.getAula().getModulo().getNombre();
            DTO_HorariosResponse dtoHorariosResponse = DTO_HorariosResponse.builder()
                    .id(horario.getId())
                    .horaInicio(horario.getHoraInicio())
                    .horaFin(horario.getHoraFin())
                    .dia(horario.getDia())
                    .aula(nombreAula)
                    .build();
            responseList.add(dtoHorariosResponse);
        }
        return responseList;
    }
}
