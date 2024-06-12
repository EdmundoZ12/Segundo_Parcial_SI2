package com.backend.backend.Usuario.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Response {

    String nro_registro;
    String ci;
    String nombre;
    String apellido;
    String email;
    String direccion;
    Integer telefono;
    Date fechaNacimiento;
    Integer id_rol;
}
