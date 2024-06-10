package com.backend.backend.Materia;

import com.backend.backend.Materia.DTO.DTO_Materia;
import com.backend.backend.Materia.DTO.DTO_Materias_Grupo;
import com.backend.backend.Usuario.DTO.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materia")
@RequiredArgsConstructor
public class Materia_Controller {

    private final Materia_Service materiaService;

    @PostMapping(value = "create")
    public ResponseEntity<?> createMateria(@RequestBody DTO_Materia dtoMateria) {
        try {
            materiaService.createMateria(dtoMateria);
            return ResponseEntity.status(200).body("La Materia fue creada con Exito");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error al crear el usuario: " + e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<Materia>> getAllMaterias() {
        List<Materia> materias = materiaService.getAllMaterias();
        return ResponseEntity.ok(materias);
    }

    @GetMapping(value = "grupos")
    public ResponseEntity<List<DTO_Materias_Grupo>> getAllMateriasGrupos() {
        List<DTO_Materias_Grupo> materias = materiaService.getAllMateriasGrupo();
        return ResponseEntity.ok(materias);
    }
}
