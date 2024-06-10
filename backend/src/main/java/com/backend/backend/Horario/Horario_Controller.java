package com.backend.backend.Horario;

import com.backend.backend.Carrera.DTO.DTO_Carrera_Materias;
import com.backend.backend.Horario.DTO.DTO_Horario_Create;
import com.backend.backend.Usuario.DTO.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/horario")
@RequiredArgsConstructor
public class Horario_Controller {

    private final Horario_Service horarioService;

    @PostMapping(value = "create")
    public ResponseEntity<?> añadirHorarios(@RequestBody DTO_Horario_Create dtoHorarioCreate) {
        try {
            horarioService.crearHorarios(dtoHorarioCreate);
            return ResponseEntity.status(200).body("Horarios creados con Exito");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error al crear el usuario: " + e.getMessage()));
        }
    }
}
