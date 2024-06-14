package com.backend.backend.Asistencia;

import com.backend.backend.Horario.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface Asistencia_Repository extends JpaRepository<Asistencia, Integer> {
    boolean existsByFecha(Date fecha);

    Optional<Asistencia> findById(Integer id);

    boolean existsByHoraEntrada(LocalTime horaInicio);

    boolean existsByFechaAndHoraEntrada(LocalTime horaEntrada, Date fecha);


    List<Asistencia> findByGestionDocente_CodMateriaAndGestionDocente_IdGrupoAndGestionDocente_IdGestion(String codMateria, Integer idGrupo, Integer idGestion);

    boolean existsByFechaAndHoraEntradaAndGestionDocente_Docente_NroRegistroAndGestionDocente_CodMateriaAndGestionDocente_IdGrupoAndGestionDocente_IdGestion(
            Date fecha, LocalTime horaEntrada, String nroRegistro, String codMateria, Integer idGrupo, Integer idGestion);

    boolean existsByFechaAndGestionDocente_Docente_NroRegistroAndGestionDocente_CodMateriaAndGestionDocente_IdGrupoAndGestionDocente_IdGestion(
            Date fecha, String nroRegistro, String codMateria, Integer idGrupo, Integer idGestion);


    List<Asistencia> findByTipoAsistencia_IdAndDocente_NroRegistro(Integer idTipoAsistencia, String nroRegistro);

}
