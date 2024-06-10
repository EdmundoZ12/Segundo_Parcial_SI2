package com.backend.backend.Aula.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Aulas_Modulo {
    String nombre;
    Integer id_aula;
    Integer id_modulo;

}
