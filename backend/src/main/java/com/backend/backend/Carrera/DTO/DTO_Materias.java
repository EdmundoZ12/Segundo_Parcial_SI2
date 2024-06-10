package com.backend.backend.Carrera.DTO;

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
    String nombre_materia;
}
