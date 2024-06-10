package com.backend.backend.Horario;

import com.backend.backend.Aula.Aula;
import com.backend.backend.Grupo.Grupo;
import com.backend.backend.Materia_Grupo.MateriaGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface Horario_Repository extends JpaRepository<Horario, Integer> {
    boolean existsByDia(String nombre);

    Optional<Horario> findById(Integer id);

    boolean existsByHoraInicio(LocalTime horaInicio);

    boolean existsByHoraFin(LocalTime horaFin);

    boolean existsByHoraInicioAndHoraFin(LocalTime horaInicio, LocalTime horaFin);

    boolean existsByAula(Aula aula);

    List<Horario> findByMateriaGrupo_CodMateriaAndMateriaGrupo_IdGrupo(String codMateria, Integer idGrupo);

    boolean existsByAulaAndDiaAndHoraInicioAndHoraFinAndMateriaGrupo(Aula aula, String dia, LocalTime horaInicio, LocalTime horaFin, MateriaGrupo materiaGrupo);


}
