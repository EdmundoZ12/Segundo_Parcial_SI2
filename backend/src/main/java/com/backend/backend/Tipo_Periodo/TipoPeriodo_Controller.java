package com.backend.backend.Tipo_Periodo;

import com.backend.backend.Tipo_Periodo.DTO.DTO_TipPeriodo;
import com.backend.backend.Usuario.DTO.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tipo-periodo")
@RequiredArgsConstructor
public class TipoPeriodo_Controller {

    private final TipoPeriodo_Service tipoPeriodoService;

    @PostMapping(value = "create")
    public ResponseEntity<?> createTip_Periodo(@RequestBody DTO_TipPeriodo tipPeriodo) {
        try {
            TipoPeriodo periodo = tipoPeriodoService.createTipo_Periodo(tipPeriodo);
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("message", "Creado con éxito"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error al crear el usuario: " + e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<TipoPeriodo>> getAllTips_Periodo() {
        List<TipoPeriodo> periodos = tipoPeriodoService.getAllTipos_Periodo();
        return ResponseEntity.ok(periodos);
    }
}
