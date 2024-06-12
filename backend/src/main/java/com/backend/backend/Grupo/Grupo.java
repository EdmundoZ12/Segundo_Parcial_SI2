package com.backend.backend.Grupo;

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
@Table(name = "grupo", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "grupo")
    @JsonIgnore
    private List<MateriaGrupo> materiaGrupos = new ArrayList<>();
}
