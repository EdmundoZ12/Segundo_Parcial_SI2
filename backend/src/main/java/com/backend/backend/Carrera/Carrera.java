package com.backend.backend.Carrera;

import com.backend.backend.Carrera_Materia.CarreraMateria;
import com.backend.backend.Modalidad.Modalidad;
import com.backend.backend.Modalidad_Carrera.ModalidadCarrera;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carrera", uniqueConstraints = {@UniqueConstraint(columnNames = {"cod"})})
public class Carrera {
    @Id
    @Column(length = 15, nullable = false, unique = true)
    private String cod;

    @Column(nullable = false, length = 150)
    private String nombre;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "carrera")
    private List<ModalidadCarrera> modalidadCarreras = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "carrera")
    private List<CarreraMateria> carreraMaterias = new ArrayList<>();

}
