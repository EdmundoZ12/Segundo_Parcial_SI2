package com.backend.backend.Asistencia.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Licencia {
    String nro_registro;
    Integer id_grupo;
    String cod_materia;
    String motivo;
    Date fecha;
}
