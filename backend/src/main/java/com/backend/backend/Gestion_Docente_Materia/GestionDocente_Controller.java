package com.backend.backend.Gestion_Docente_Materia;

import com.backend.backend.Gestion_Docente_Materia.DTO.DTO_Asignar_Gestion_Docente;
import com.backend.backend.Gestion_Docente_Materia.DTO.DTO_Materias;
import com.backend.backend.Horario.Horario;
import com.backend.backend.Usuario.DTO.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/materias/{nro_registro}")
    public ResponseEntity<List<DTO_Materias>> obtenerHorariosPorMateriaYGrupo(@PathVariable String nro_registro) {
        // Aquí puedes utilizar el número de registro para obtener los horarios
        List<DTO_Materias> materias = gestionDocenteService.getMateriasByDocenteAndLatestGestion(nro_registro);
        return ResponseEntity.ok(materias);
    }

    @GetMapping("/horarios/{nro_registro}")
    public ResponseEntity<List<Horario>> obtenerHorariosCercas(@PathVariable String nro_registro) {
        // Aquí puedes utilizar el número de registro para obtener los horarios
        List<Horario> materias = gestionDocenteService.getHorariosCerca(nro_registro);
        return ResponseEntity.ok(materias);
    }
}
