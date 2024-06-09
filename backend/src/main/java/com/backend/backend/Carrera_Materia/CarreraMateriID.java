package com.backend.backend.Carrera_Materia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarreraMateriID implements Serializable {
    private String codMateria;
    private String codCarrera;
}
