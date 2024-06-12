package com.backend.backend.Grupo;

import com.backend.backend.Grupo.DTO.DTO_Grupo;
import com.backend.backend.Rol.DTO.DTO_Rol;
import com.backend.backend.Rol.Rol;
import com.backend.backend.Usuario.DTO.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupo")
@RequiredArgsConstructor
public class Grupo_Controller {

    private final Grupo_Service grupoService;

    @PostMapping(value = "create")
    public ResponseEntity<?> createGrupo(@RequestBody DTO_Grupo dtoGrupo) {
        try {
            grupoService.createGrupo(dtoGrupo);
            return ResponseEntity.status(200).body("Grupo creado con exito");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error al crear el usuario: " + e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<Grupo>> getAllGrupos() {
        List<Grupo> grupos = grupoService.getAllGrupos();
        return ResponseEntity.ok(grupos);
    }
}
