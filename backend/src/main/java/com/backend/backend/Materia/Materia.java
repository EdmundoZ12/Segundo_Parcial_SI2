package com.backend.backend.Materia;

import com.backend.backend.Carrera_Materia.CarreraMateria;
import com.backend.backend.Materia_Grupo.MateriaGrupo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "materia", uniqueConstraints = {@UniqueConstraint(columnNames = {"cod"})})
public class Materia {
    @Id
    @Column(length = 10, nullable = false, unique = true)
    private String cod;

    @Column(nullable = false, length = 255)
    private String nombre;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "materia")
    @JsonIgnore
    private List<CarreraMateria> carreraMaterias = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "materia")
    @JsonIgnore
    private List<MateriaGrupo> materiaGrupos = new ArrayList<>();
}
