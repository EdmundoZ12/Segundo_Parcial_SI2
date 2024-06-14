package com.backend.backend.Asistencia;

import com.backend.backend.Asistencia.DTO.DTO_Asistencia;
import com.backend.backend.Asistencia.DTO.DTO_Licencia;
import com.backend.backend.Usuario.DTO.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asistencia")
@RequiredArgsConstructor
public class Asistencia_Controller {

    private final Asistencia_Service asistenciaService;

    @PostMapping(value = "create")
    public ResponseEntity<?> marcarAsistencia(@RequestBody DTO_Asistencia dtoAsistencia) {
        try {
            asistenciaService.crearAsistencia(dtoAsistencia);
            return ResponseEntity.status(200).body("Asistencia marcada con exito");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error al crear el usuario: " + e.getMessage()));
        }
    }

    @PostMapping(value = "/create/licencia")
    public ResponseEntity<?> crearLicensia(@RequestBody DTO_Licencia dtoLicencia) {
        try {
            asistenciaService.crearLicencia(dtoLicencia);
            return ResponseEntity.status(200).body("Licensia creada con exito");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error al crear el usuario: " + e.getMessage()));
        }
    }
}
