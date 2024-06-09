package com.backend.backend.GestionCarrera;

import com.backend.backend.Gestion.Gestion;
import com.backend.backend.Modalidad_Carrera.ModalidadCarrera;
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
@IdClass(GestionCarreraID.class)
@Table(name = "gestion_carrera")
public class GestionCarrera {
    @Id
    @Column(name = "id_modalidad")
    private Integer idModalidad;

    @Id
    @Column(name = "id_gestion")
    private Integer idGestion;

    @Id
    @Column(name = "cod_carrera", length = 15, nullable = false)
    private String codCarrera;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_modalidad", referencedColumnName = "id_modalidad", insertable = false, updatable = false),
            @JoinColumn(name = "cod_carrera", referencedColumnName = "cod_carrera", insertable = false, updatable = false)
    })
    private ModalidadCarrera modalidadCarrera;

    @ManyToOne
    @JoinColumn(name = "id_gestion", referencedColumnName = "id", insertable = false, updatable = false)
    private Gestion gestion;
}
