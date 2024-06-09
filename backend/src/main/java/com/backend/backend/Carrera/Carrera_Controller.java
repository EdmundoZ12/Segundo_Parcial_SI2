package com.backend.backend.Carrera;

import com.backend.backend.Carrera.DTO.DTO_Carrera;
import com.backend.backend.Carrera.DTO.DTO_Carrera_Response;
import com.backend.backend.Usuario.DTO.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrera")
@RequiredArgsConstructor
public class Carrera_Controller {

    private final Carrera_Service carreraService;

    @PostMapping(value = "create")
    public ResponseEntity<?> createCarrera(@RequestBody DTO_Carrera dto_carrera) {
        try {
            System.out.println(dto_carrera);
            carreraService.createCarrera(dto_carrera);
            return ResponseEntity.status(200).body("La carrera fue creada con Exito");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error al crear el usuario: " + e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<DTO_Carrera_Response>> getAllCarreras() {
        List<DTO_Carrera_Response> carreras = carreraService.getAllCarreras();
        return ResponseEntity.ok(carreras);
    }

    @PutMapping("/{cod}")
    public ResponseEntity<?> updateCarrera(@PathVariable("cod") String cod, @RequestBody DTO_Carrera dto_carrera) {
        try {
            Carrera carrera = carreraService.updateCarrera(cod, dto_carrera);
            return ResponseEntity.ok(carrera);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error al actualizar el usuario: " + e.getMessage()));
        }
    }

    @GetMapping("/{cod}")
    public ResponseEntity<DTO_Carrera> getCarrera(@PathVariable("cod") String cod) {
        Carrera carrera = carreraService.getCarrera(cod);
        DTO_Carrera dto_carrera = DTO_Carrera.builder()
                .cod(carrera.getCod())
                .nombre(carrera.getNombre())
                .build();
        return ResponseEntity.ok(dto_carrera);
    }
}
