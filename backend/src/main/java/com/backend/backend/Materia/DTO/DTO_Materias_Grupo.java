package com.backend.backend.Materia.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Materias_Grupo {
    String nombre;
    Integer id_grupo;
    String cod_materia;
}
