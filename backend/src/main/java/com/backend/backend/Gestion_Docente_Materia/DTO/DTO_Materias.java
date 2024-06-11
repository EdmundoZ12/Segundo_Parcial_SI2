package com.backend.backend.Gestion_Docente_Materia.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Materias {
    String cod_materia;
    Integer id_grupo;
}
