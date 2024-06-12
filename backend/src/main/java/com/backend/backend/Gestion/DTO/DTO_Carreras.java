package com.backend.backend.Gestion.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Carreras {
    String nombre_carrera;
    String cod_carrera;
    Integer id_modalidad;
    String nombre_modalidad;
    Integer id_tcarrera;
    String nombre_tcarrera;
}
