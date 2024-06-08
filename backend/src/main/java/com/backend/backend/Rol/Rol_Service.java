package com.backend.backend.Rol;

import com.backend.backend.Rol.DTO.DTO_Rol;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Rol_Service {
    private final Rol_Repository rolRepository;

    public Rol createRol(DTO_Rol dtoRol) {
        if (rolRepository.existsByNombre(dtoRol.getNombre())) {
            throw new RuntimeException("El rol ya existe");
        }

        Rol rol = Rol.builder()
                .nombre(dtoRol.getNombre())
                .descripcion(dtoRol.getDescripcion())
                .build();

        return rolRepository.save(rol);
    }

    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }
}
