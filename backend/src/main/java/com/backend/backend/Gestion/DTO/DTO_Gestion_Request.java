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
public class DTO_Gestion_Request {
    private String nombre;
    private LocalDate fecha_inicio;
    private LocalDate fecha_final;
    private Integer id_tperiodo;
}
