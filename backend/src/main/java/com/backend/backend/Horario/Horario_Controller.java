package com.backend.backend.Horario;

import com.backend.backend.Carrera.DTO.DTO_Carrera_Materias;
import com.backend.backend.Horario.DTO.DTO_Horario_Create;
import com.backend.backend.Horario.DTO.DTO_HorariosResponse;
import com.backend.backend.Usuario.DTO.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horario")
@RequiredArgsConstructor
public class Horario_Controller {

    private final Horario_Service horarioService;

    @PostMapping(value = "create")
    public ResponseEntity<?> añadirHorarios(@RequestBody DTO_Horario_Create dtoHorarioCreate) {
        try {
            horarioService.crearHorarios(dtoHorarioCreate);
            return ResponseEntity.status(200).body("Horarios creados con Exito");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error al crear el usuario: " + e.getMessage()));
        }
    }

    @GetMapping("/materia/{codMateria}/grupo/{idGrupo}")
    public ResponseEntity<List<Horario>> obtenerHorariosPorMateriaYGrupo(@PathVariable String codMateria, @PathVariable Integer idGrupo) {
        List<Horario> horarios = horarioService.getHorariosPorMateriaYGrupo(codMateria, idGrupo);
        return ResponseEntity.ok(horarios);
    }

    @GetMapping("/materia1/{codMateria}/grupo1/{idGrupo}")
    public ResponseEntity<List<DTO_HorariosResponse>> obtenerHorariosMateriaGrupo(@PathVariable String codMateria, @PathVariable Integer idGrupo) {
        List<DTO_HorariosResponse> horarios = horarioService.getHorariosMateriaGrupo(codMateria, idGrupo);
        return ResponseEntity.ok(horarios);
    }
}
