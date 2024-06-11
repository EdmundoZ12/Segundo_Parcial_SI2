package com.backend.backend.Gestion_Docente_Materia;

import com.backend.backend.Gestion.DTO.DTO_Gestion_Request;
import com.backend.backend.Gestion_Docente_Materia.DTO.DTO_Asignar_Gestion_Docente;
import com.backend.backend.Usuario.DTO.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/docente-materia")
@RequiredArgsConstructor
public class GestionDocente_Controller {

    private final GestionDocente_Service gestionDocenteService;

    @PostMapping(value = "create")
    public ResponseEntity<?> asignarDocenteMateria(@RequestBody DTO_Asignar_Gestion_Docente dtoAsignarGestionDocente) {
        try {
            gestionDocenteService.createGestionDocente(dtoAsignarGestionDocente);
            return ResponseEntity.status(200).body("Asignacion de Materias al docente con exito");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error al crear el usuario: " + e.getMessage()));
        }
    }
}
