package com.backend.backend.Gestion.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Gestion {
    String nombre;
    Integer id;
    LocalDate fecha_inicio;
    LocalDate fecha_final;
    Integer id_tperiodo;
    String nombre_tperiodo;
}
