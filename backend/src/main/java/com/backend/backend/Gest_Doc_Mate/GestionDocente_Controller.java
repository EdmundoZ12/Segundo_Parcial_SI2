package com.backend.backend.Gest_Doc_Mate;

import com.backend.backend.Gest_Doc_Mate.DTO.DTO_Asignar_Gestion_Docente;
import com.backend.backend.Gest_Doc_Mate.DTO.DTO_AsistenciaDocente;
import com.backend.backend.Gest_Doc_Mate.DTO.DTO_Horarios_Cercas;
import com.backend.backend.Gest_Doc_Mate.DTO.DTO_Materias;
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

    @GetMapping("/asistencias/{nro_registro}")
    public ResponseEntity<List<DTO_AsistenciaDocente>> obtenerAsistenciasDocente(@PathVariable String nro_registro) {
        // Aquí puedes utilizar el número de registro para obtener los horarios
        List<DTO_AsistenciaDocente> materias = gestionDocenteService.asistenciaDocente(nro_registro);
        return ResponseEntity.ok(materias);
    }

    @GetMapping("/faltas/{nro_registro}")
    public ResponseEntity<List<DTO_AsistenciaDocente>> obtenerFaltasDocente(@PathVariable String nro_registro) {
        // Aquí puedes utilizar el número de registro para obtener los horarios
        List<DTO_AsistenciaDocente> materias = gestionDocenteService.faltasDocente(nro_registro);
        return ResponseEntity.ok(materias);
    }

    @GetMapping("/retrasos/{nro_registro}")
    public ResponseEntity<List<DTO_AsistenciaDocente>> obtenerRetrasosDocente(@PathVariable String nro_registro) {
        // Aquí puedes utilizar el número de registro para obtener los horarios
        List<DTO_AsistenciaDocente> materias = gestionDocenteService.retrasosDocente(nro_registro);
        return ResponseEntity.ok(materias);
    }

    @GetMapping("/licencias/{nro_registro}")
    public ResponseEntity<List<DTO_AsistenciaDocente>> obtenerLicenciasDocente(@PathVariable String nro_registro) {
        // Aquí puedes utilizar el número de registro para obtener los horarios
        List<DTO_AsistenciaDocente> materias = gestionDocenteService.licenciasDocente(nro_registro);
        return ResponseEntity.ok(materias);
    }

    @GetMapping("/horarios/{nro_registro}")
    public ResponseEntity<List<DTO_Horarios_Cercas>> obtenerHorariosCercas(@PathVariable String nro_registro) {
        // Aquí puedes utilizar el número de registro para obtener los horarios
        List<DTO_Horarios_Cercas> materias = gestionDocenteService.getHorariosCerca(nro_registro);
        return ResponseEntity.ok(materias);
    }
}
