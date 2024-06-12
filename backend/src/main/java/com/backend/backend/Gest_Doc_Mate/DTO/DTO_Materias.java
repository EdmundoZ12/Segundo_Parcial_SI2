package com.backend.backend.Gest_Doc_Mate.DTO;

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
    String nombre_materia;
    String nombre_grupo;
}
