package com.backend.backend.Materia_Grupo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MateriaGrupoID implements Serializable {
    private Integer idGrupo;
    private String codMateria;
}
