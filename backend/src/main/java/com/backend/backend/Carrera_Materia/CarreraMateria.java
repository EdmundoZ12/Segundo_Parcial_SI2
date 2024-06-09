package com.backend.backend.Carrera_Materia;

import com.backend.backend.Carrera.Carrera;
import com.backend.backend.Materia.Materia;
import com.backend.backend.Modalidad.Modalidad;
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
@IdClass(CarreraMateriID.class)
@Table(name = "carrera_materia")
public class CarreraMateria {

    @Id
    @Column(name = "cod_carrera", length = 15, nullable = false)
    private String codCarrera;

    @Id
    @Column(name = "cod_materia", length = 10, nullable = false)
    private String codMateria;

    @ManyToOne
    @JoinColumn(name = "cod_carrera", referencedColumnName = "cod", insertable = false, updatable = false)
    private Carrera carrera;

    @ManyToOne
    @JoinColumn(name = "cod_materia", referencedColumnName = "cod", insertable = false, updatable = false)
    private Materia materia;


}
