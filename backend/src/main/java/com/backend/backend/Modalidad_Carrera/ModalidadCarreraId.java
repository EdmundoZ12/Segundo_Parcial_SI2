package com.backend.backend.Modalidad_Carrera;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModalidadCarreraId implements Serializable {
    private Integer idModalidad;
    private String codCarrera;
}
