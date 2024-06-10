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
public class DTO_Horario {
    String dia;
    LocalTime hora_inicio;
    LocalTime hora_fin;
    Integer id_aula;


}
