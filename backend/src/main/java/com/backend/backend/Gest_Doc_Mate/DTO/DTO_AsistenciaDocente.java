package com.backend.backend.Gest_Doc_Mate.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_AsistenciaDocente {

    Date fecha;
    LocalTime hora;
    String motivo;
    String modalidad;
    String nombre_materia;
}
