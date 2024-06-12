package com.backend.backend.Gestion_Carrera;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GestionCarreraID implements Serializable {
    private Integer idModalidad;
    private String codCarrera;
    private  Integer idGestion;
}
