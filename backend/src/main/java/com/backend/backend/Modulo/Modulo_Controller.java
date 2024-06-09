package com.backend.backend.Modulo;

import com.backend.backend.Aula.Aula;
import com.backend.backend.Modalidad.Modalidad_Service;
import com.backend.backend.Modulo.DTO.DTO_Modulo;
import com.backend.backend.Usuario.DTO.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modulo")
@RequiredArgsConstructor
public class Modulo_Controller {

    private final Modulo_Service moduloService;

    @PostMapping(value = "create")
    public ResponseEntity<?> createModulo(@RequestBody DTO_Modulo dtoModulo) {
        try {
            moduloService.createModulo(dtoModulo);
            return ResponseEntity.status(200).body("El Modulo fue creado con Exito");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error al crear el usuario: " + e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<Modulo>> getAllModulos() {
        List<Modulo> modulos = moduloService.getAllModulos();
        return ResponseEntity.ok(modulos);
    }

    @GetMapping("/aulas/{id}")
    public ResponseEntity<List<Aula>> getAulasByModuloId(@PathVariable("id") Integer id) {
        List<Aula> aulas = moduloService.getAulasByModuloId(id);
        return new ResponseEntity<>(aulas, HttpStatus.OK);
    }
}
