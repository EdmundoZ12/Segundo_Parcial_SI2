package com.backend.backend.Tipo_Asistencia;

import com.backend.backend.Modalidad.DTO.DTO_Modalidad;
import com.backend.backend.Modalidad.Modalidad;
import com.backend.backend.Tipo_Asistencia.DTO.DTO_TipAsistencia;
import com.backend.backend.Usuario.DTO.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-asistencia")
@RequiredArgsConstructor
public class TipoAsistencia_Controller {

    private final TipoAsistencia_Service tipoAsistenciaService;

    @PostMapping(value = "create")
    public ResponseEntity<?> createTipoAsistencia(@RequestBody DTO_TipAsistencia dtoTipAsistencia) {
        try {
            tipoAsistenciaService.createTipo_Asistencia(dtoTipAsistencia);
            return ResponseEntity.status(200).body("Tipo de Asistencia creado con exito");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error al crear el usuario: " + e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<TipoAsistencia>> getAllTipsAsistencia() {
        List<TipoAsistencia> asistencias = tipoAsistenciaService.getAllTipos_Asistencia();
        return ResponseEntity.ok(asistencias);
    }
}
