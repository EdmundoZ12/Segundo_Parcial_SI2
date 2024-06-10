package com.backend.backend.Horario;

import com.backend.backend.Aula.Aula;
import com.backend.backend.Grupo.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface Horario_Repository extends JpaRepository<Horario, Integer> {
    boolean existsByDia(String nombre);

    Optional<Horario> findById(Integer id);

    boolean existsByHoraInicio(LocalTime horaInicio);

    boolean existsByHoraFin(LocalTime horaFin);

    boolean existsByHoraInicioAndHoraFin(LocalTime horaInicio, LocalTime horaFin);

    boolean existsByAula(Aula aula);

}
