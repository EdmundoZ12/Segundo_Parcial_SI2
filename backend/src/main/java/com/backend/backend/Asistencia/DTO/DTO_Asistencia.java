package com.backend.backend.Asistencia.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Asistencia {
    String nro_registro;
    Integer id_horario;
    Integer id_grupo;
    String cod_materia;
    String motivo;
    String modalidad;
}
