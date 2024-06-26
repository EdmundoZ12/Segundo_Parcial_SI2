package com.backend.backend.Horario;

import com.backend.backend.Aula.Aula;
import com.backend.backend.Materia_Grupo.MateriaGrupo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "horario", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 15)
    private String dia;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    @ManyToOne(fetch = FetchType.EAGER) // Cambio aquí
    @JoinColumn(name = "id_aula", nullable = false)
    @JsonIgnore
    private Aula aula;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo"),
            @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia")
    })
    @JsonIgnore
    private MateriaGrupo materiaGrupo;


}
