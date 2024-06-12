package com.backend.backend.Gestion;

import com.backend.backend.Gestion_Carrera.GestionCarrera;
import com.backend.backend.Gest_Doc_Mate.GestionDocente;
import com.backend.backend.Tipo_Periodo.TipoPeriodo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gestion", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Gestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 80)
    private String nombre;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_final", nullable = false)
    private LocalDate fechaFinal;

    @OneToMany(mappedBy = "gestion")
    private List<GestionCarrera> gestionCarreras = new ArrayList<>();

    @OneToMany(mappedBy = "gestion")
    private List<GestionDocente> gestionDocentes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER) // Cambio aquí
    @JoinColumn(name = "id_tperiodo", nullable = false)
    @JsonIgnore
    private TipoPeriodo tipoPeriodo;
}
