package com.backend.backend.Modalidad_Carrera;

import com.backend.backend.Carrera.Carrera;
import com.backend.backend.GestionCarrera.GestionCarrera;
import com.backend.backend.Modalidad.Modalidad;
import com.backend.backend.Tipo_Carrera.TipoCarrera;
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
@IdClass(ModalidadCarreraId.class)
@Table(name = "modalidad_carrera")
public class ModalidadCarrera {
    @Id
    @Column(name = "id_modalidad")
    private Integer idModalidad;

    @Id
    @Column(name = "cod_carrera", length = 15, nullable = false)
    private String codCarrera;

    @ManyToOne
    @JoinColumn(name = "id_modalidad", referencedColumnName = "id", insertable = false, updatable = false)
    private Modalidad modalidad;

    @ManyToOne
    @JoinColumn(name = "cod_carrera", referencedColumnName = "cod", insertable = false, updatable = false)
    private Carrera carrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tcarrera", nullable = false)
    private TipoCarrera tipoCarrera;

    @OneToMany(mappedBy = "modalidadCarrera")
    private List<GestionCarrera> gestionCarreras = new ArrayList<>();

}