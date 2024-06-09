package com.backend.backend.Gestion;

import com.backend.backend.Carrera.DTO.DTO_Carrera_Response;
import com.backend.backend.Gestion.DTO.DTO_Gestion;
import com.backend.backend.Gestion.DTO.DTO_Gestion_Request;
import com.backend.backend.Gestion.DTO.DTO_Gestion_Response;
import com.backend.backend.Usuario.DTO.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gestion")
@RequiredArgsConstructor
public class Gestion_Controller {

    private final Gestion_Service gestionService;

    @PostMapping(value = "create")
    public ResponseEntity<?> createGestion(@RequestBody DTO_Gestion_Request dtoGestionRequest) {
        try {
            gestionService.createGestion(dtoGestionRequest);
            return ResponseEntity.status(200).body("La Gestion fue creada con Exito");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error al crear el usuario: " + e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<DTO_Gestion>> getAllGestiones() {
        List<DTO_Gestion> gestiones = gestionService.getAllGestiones();
        return ResponseEntity.ok(gestiones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO_Gestion_Response> getGestionId(@PathVariable("id") Integer id) {
        System.out.println(id);
        DTO_Gestion_Response dtoGestionResponse = gestionService.getGestion(id);
        return ResponseEntity.ok(dtoGestionResponse);
    }
}
