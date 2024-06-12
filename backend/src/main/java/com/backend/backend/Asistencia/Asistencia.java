package com.backend.backend.Asistencia;

import com.backend.backend.Docente.Docente;
import com.backend.backend.Gestion_Docente_Materia.GestionDocente;
import com.backend.backend.Tipo_Asistencia.TipoAsistencia;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "asistencia", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "hora_entrada")
    private LocalTime horaEntrada;

    @Column(nullable = false, length = 20)
    private String modalidad;

    @Column(nullable = true)
    private String motivo;

    @ManyToOne(fetch = FetchType.EAGER) // Cambio aquí
    @JoinColumn(name = "id_tasistencia", nullable = false)
    @JsonIgnore
    private TipoAsistencia tipoAsistencia;

    @ManyToOne(fetch = FetchType.EAGER) // Cambio aquí
    @JoinColumn(name = "nro_registro", nullable = false)
    private Docente docente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo"),
            @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia"),
            @JoinColumn(name = "id_gestion", referencedColumnName = "id_gestion")
    })
    @JsonIgnore
    private GestionDocente gestionDocente;
}
