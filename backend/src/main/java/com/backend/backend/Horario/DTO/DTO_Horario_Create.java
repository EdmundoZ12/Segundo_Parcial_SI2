package com.backend.backend.Horario.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Horario_Create {
    Integer id_grupo;
    String cod_materia;
    List<DTO_Horario> horarios;
}
