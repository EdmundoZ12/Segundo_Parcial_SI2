package com.backend.backend.Aula;

import com.backend.backend.Aula.DTO.DTO_Aula;
import com.backend.backend.Aula.DTO.DTO_Aulas_Modulo;
import com.backend.backend.Materia.DTO.DTO_Materias_Grupo;
import com.backend.backend.Usuario.DTO.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aula")
@RequiredArgsConstructor
public class Aula_Controller {

    private final Aula_Service aulaService;

    @PostMapping(value = "create")
    public ResponseEntity<?> createAula(@RequestBody DTO_Aula dtoAula) {
        try {
            aulaService.createAula(dtoAula);
            return ResponseEntity.status(200).body("El Aula fue creada con exito");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error al crear el usuario: " + e.getMessage()));
        }
    }

    @GetMapping(value = "modulos")
    public ResponseEntity<List<DTO_Aulas_Modulo>> getAllAulasModulo() {
        List<DTO_Aulas_Modulo> aulas = aulaService.getAllAulas_Modulo();
        return ResponseEntity.ok(aulas);
    }
}
