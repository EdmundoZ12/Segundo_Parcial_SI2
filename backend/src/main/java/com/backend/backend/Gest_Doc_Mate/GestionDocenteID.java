package com.backend.backend.Gest_Doc_Mate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GestionDocenteID implements Serializable {

    private Integer idGestion;
    private String codMateria;
    private  Integer idGrupo;
}
