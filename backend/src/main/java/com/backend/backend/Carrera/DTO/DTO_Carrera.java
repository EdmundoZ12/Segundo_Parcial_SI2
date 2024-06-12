package com.backend.backend.Carrera.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Carrera {
    String cod;
    String nombre;
    Integer id_modalidad;
    Integer id_tcarrera;
}
