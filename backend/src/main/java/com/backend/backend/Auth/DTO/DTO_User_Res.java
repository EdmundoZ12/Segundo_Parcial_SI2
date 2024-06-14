package com.backend.backend.Auth.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTO_User_Res {
    String nro_registro;
    String nombre;
    Integer id_rol;
}
