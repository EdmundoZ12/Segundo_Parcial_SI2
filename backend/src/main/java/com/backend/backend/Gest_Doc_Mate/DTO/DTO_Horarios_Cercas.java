package com.backend.backend.Gest_Doc_Mate.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Horarios_Cercas {
    Integer id_horario;
    Integer id_grupo;
    String dia;
    LocalTime horaInicio;
    LocalTime horaFin;
    String nombre;
    String cod_materia;
}
