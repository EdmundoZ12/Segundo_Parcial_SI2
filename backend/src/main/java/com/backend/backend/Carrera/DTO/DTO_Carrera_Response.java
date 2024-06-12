package com.backend.backend.Carrera.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Carrera_Response {
    String cod;
    String nombre_carrera;
    Integer id_modalidad;
    Integer id_tcarrera;
    String nombre_modalidad;
    String nombre_tcarrera;
}
