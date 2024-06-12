package com.backend.backend.Grupo;

import com.backend.backend.Grupo.DTO.DTO_Grupo;
import com.backend.backend.Rol.DTO.DTO_Rol;
import com.backend.backend.Rol.Rol;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Grupo_Service {

    private final Grupo_Repository grupoRepository;

    public void createGrupo(DTO_Grupo dtoGrupo) {
        if (grupoRepository.existsByNombre(dtoGrupo.getNombre())) {
            throw new RuntimeException("El Nombre de grupo ya existe");
        }

        Grupo grupo = Grupo.builder()
                .nombre(dtoGrupo.getNombre())
                .build();

        grupoRepository.save(grupo);
    }

    public List<Grupo> getAllGrupos() {
        return grupoRepository.findAll();
    }
}
