package com.backend.backend.Modalidad;

import com.backend.backend.Modalidad.DTO.DTO_Modalidad;
import com.backend.backend.Usuario.DTO.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modalidad")
@RequiredArgsConstructor
public class Modalidad_Controller {

    private final Modalidad_Service modalidadService;

    @PostMapping(value = "create")
    public ResponseEntity<?> createModalidad(@RequestBody DTO_Modalidad dtoModalidad) {
        try {
            modalidadService.createModalidad(dtoModalidad);
            return ResponseEntity.status(200).body("La Modalidad fue creada con Exito");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error al crear el usuario: " + e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<Modalidad>> getAllModalidades() {
        List<Modalidad> modalidades = modalidadService.getAllModalidades();
        return ResponseEntity.ok(modalidades);
    }
}
