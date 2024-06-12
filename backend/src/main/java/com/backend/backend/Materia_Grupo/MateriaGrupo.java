package com.backend.backend.Materia_Grupo;

import com.backend.backend.Gest_Doc_Mate.GestionDocente;
import com.backend.backend.Grupo.Grupo;
import com.backend.backend.Materia.Materia;
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
@IdClass(MateriaGrupoID.class)
@Table(name = "materia_grupo")
public class MateriaGrupo {
    @Id
    @Column(name = "cod_materia", length = 10, nullable = false)
    private String codMateria;

    @Id
    @Column(name = "id_grupo")
    private Integer idGrupo;

    @ManyToOne
    @JoinColumn(name = "id_grupo", referencedColumnName = "id", insertable = false, updatable = false)
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "cod_materia", referencedColumnName = "cod", insertable = false, updatable = false)
    private Materia materia;

    @OneToMany(mappedBy = "materiaGrupo")
    @JsonIgnore
    private List<GestionDocente> gestionDocentes = new ArrayList<>();
}
