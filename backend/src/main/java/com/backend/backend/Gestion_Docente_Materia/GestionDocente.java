package com.backend.backend.Gestion_Docente_Materia;

import com.backend.backend.Docente.Docente;
import com.backend.backend.Gestion.Gestion;
import com.backend.backend.Materia_Grupo.MateriaGrupo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(GestionDocenteID.class)
@Table(name = "gestion_docente")
public class GestionDocente {

    @Id
    @Column(name = "id_grupo")
    private Integer idGrupo;

    @Id
    @Column(name = "id_gestion")
    private Integer idGestion;

    @Id
    @Column(name = "cod_materia", length = 10, nullable = false)
    private String codMateria;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo", insertable = false, updatable = false),
            @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", insertable = false, updatable = false)
    })
    private MateriaGrupo materiaGrupo;

    @ManyToOne
    @JoinColumn(name = "id_gestion", referencedColumnName = "id", insertable = false, updatable = false)
    private Gestion gestion;

    @ManyToOne(fetch = FetchType.EAGER) // Cambio aquí
    @JoinColumn(name = "nro_registro", nullable = false)
    private Docente docente;
}
