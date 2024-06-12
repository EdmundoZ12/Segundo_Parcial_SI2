package com.backend.backend.Administrador;

import com.backend.backend.Usuario.Usuario;
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
@Table(name = "administrador", uniqueConstraints = {@UniqueConstraint(columnNames = {"nroRegistro"})})
public class Administrador {
    @Id
    @Column(length = 20, nullable = false, unique = true)
    private String nroRegistro;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nro_registro", referencedColumnName = "nro_registro")
    @MapsId(value = "usuario")
    private Usuario usuario;
}
