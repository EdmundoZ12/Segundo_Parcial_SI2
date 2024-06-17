package com.backend.backend.Horario.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_HorariosResponse {
    String dia;
    LocalTime horaInicio;
    LocalTime horaFin;
    String aula;
    Integer id;
}
