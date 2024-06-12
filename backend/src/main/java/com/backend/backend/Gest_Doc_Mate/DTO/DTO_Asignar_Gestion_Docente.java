package com.backend.backend.Gest_Doc_Mate.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Asignar_Gestion_Docente {
    String nro_registro;
    Integer id_gestion;
    List<DTO_Materias> materias;
}
