package com.backend.backend.Docente;

import com.backend.backend.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "docente", uniqueConstraints = {@UniqueConstraint(columnNames = {"nroRegistro"})})
public class Docente {
    @Id
    @Column(length = 20, nullable = false, unique = true)
    private String nroRegistro;

    @OneToOne()
    @JoinColumn(name = "nro_registro", referencedColumnName = "nro_registro")
    @MapsId(value = "usuario")
    @ToString.Exclude
    private Usuario usuario;

}
