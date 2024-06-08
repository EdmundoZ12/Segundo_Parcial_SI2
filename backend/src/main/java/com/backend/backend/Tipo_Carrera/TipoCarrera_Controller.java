package com.backend.backend.Tipo_Carrera;

import com.backend.backend.Tipo_Carrera.DTO.DTO;
import com.backend.backend.Usuario.DTO.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-carrera")
@RequiredArgsConstructor
public class TipoCarrera_Controller {

    private final TipoCarrera_Service carreraService;

    @PostMapping(value = "create")
    public ResponseEntity<?> createTipo_Carrera(@RequestBody DTO dto) {
        try {
            carreraService.createTip_Carrera(dto);
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
    public ResponseEntity<List<TipoCarrera>> getAllTipos_Carrera() {
        List<TipoCarrera> tipoCarreras = carreraService.getAllTips_Carrera();
        return ResponseEntity.ok(tipoCarreras);
    }
}
