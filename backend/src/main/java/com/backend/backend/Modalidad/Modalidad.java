package com.backend.backend.Modalidad;

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
@Table(name = "modalidad", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Modalidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 80)
    private String nombre;

    @OneToMany(mappedBy = "modalidad")
    private List<ModalidadCarrera> modalidadCarreras = new ArrayList<>();
}
