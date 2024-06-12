package com.backend.backend.Gestion.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Gestion_Response {
    String nombre_gestion;
    Integer id_gestion;
    LocalDate fecha_inicio;
    LocalDate fecha_final;
    List<DTO_Carreras> carreras;
}
