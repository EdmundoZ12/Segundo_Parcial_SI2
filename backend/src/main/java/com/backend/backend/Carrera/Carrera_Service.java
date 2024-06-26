package com.backend.backend.Carrera;

import com.backend.backend.Carrera.DTO.DTO_Carrera;
import com.backend.backend.Carrera.DTO.DTO_Carrera_Materias;
import com.backend.backend.Carrera.DTO.DTO_Carrera_Response;
import com.backend.backend.Carrera.DTO.DTO_Materias;
import com.backend.backend.Carrera_Materia.CarreraMateria;
import com.backend.backend.Carrera_Materia.CarreraMateria_Repository;
import com.backend.backend.Materia.Materia;
import com.backend.backend.Materia.Materia_Repository;
import com.backend.backend.Modalidad.Modalidad;
import com.backend.backend.Modalidad.Modalidad_Repository;
import com.backend.backend.Modalidad_Carrera.ModalidadCarrera;
import com.backend.backend.Modalidad_Carrera.ModalidadCarrera_Repository;
import com.backend.backend.Tipo_Carrera.TipoCarrera;
import com.backend.backend.Tipo_Carrera.TipoCarrera_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Carrera_Service {

    private final Carrera_Repository carreraRepository;
    private final Modalidad_Repository modalidadRepository;
    private final TipoCarrera_Repository tipoCarreraRepository;
    private final ModalidadCarrera_Repository modalidadCarreraRepository;
    private final CarreraMateria_Repository carreraMateriaRepository;
    private final Materia_Repository materiaRepository;

    public void createCarrera(DTO_Carrera dtoCarrera) {

        if (dtoCarrera.getNombre() == null || dtoCarrera.getCod() == null) {
            throw new RuntimeException("Faltan datos a Registrar");
        }

        if (carreraRepository.existsByNombre(dtoCarrera.getNombre()) && carreraRepository.existsByCod(dtoCarrera.getCod())) {
            Carrera carrera = carreraRepository.getReferenceById(dtoCarrera.getCod());
        } else {

            if (carreraRepository.existsByCod(dtoCarrera.getCod())) {
                throw new RuntimeException("El Codigo de carrera ya existe");
            }

            if (carreraRepository.existsByNombre(dtoCarrera.getNombre())) {
                throw new RuntimeException("Ya existe una carrera con este nombre");
            }

            Carrera carrera = Carrera.builder()
                    .nombre(dtoCarrera.getNombre())
                    .cod(dtoCarrera.getCod())
                    .build();
            carreraRepository.save(carrera);
        }
        if (modalidadCarreraRepository.findByCodCarreraAndIdModalidad(
                dtoCarrera.getCod(), dtoCarrera.getId_modalidad()).isPresent()) {
            throw new RuntimeException("Ya existe una carrera con ese cod_carrera y id_modalidad");
        }

        TipoCarrera tipoCarrera = tipoCarreraRepository.getReferenceById(dtoCarrera.getId_tcarrera());
        ModalidadCarrera modalidadCarrera = ModalidadCarrera.builder()
                .idModalidad(dtoCarrera.getId_modalidad())
                .codCarrera(dtoCarrera.getCod())
                .tipoCarrera(tipoCarrera)
                .build();
        modalidadCarreraRepository.save(modalidadCarrera);
    }


    public void añadirMaterias(DTO_Carrera_Materias dtoCarreraMaterias) {

        if (dtoCarreraMaterias.getCod_carrera() == null) {
            throw new RuntimeException("Faltan datos a Registrar");
        }

        for (DTO_Materias materias : dtoCarreraMaterias.getMaterias()) {
            if (carreraMateriaRepository.findByCodCarreraAndCodMateria(dtoCarreraMaterias.getCod_carrera(), materias.getCod_materia()).isPresent()) {
                continue;
            }

            CarreraMateria carreraMateria = CarreraMateria.builder()
                    .codCarrera(dtoCarreraMaterias.getCod_carrera())
                    .codMateria(materias.getCod_materia())
                    .build();
            carreraMateriaRepository.save(carreraMateria);
        }

    }

    public List<DTO_Carrera_Response> getAllCarreras() {
        List<ModalidadCarrera> modalidadCarreras = modalidadCarreraRepository.findAll();
        List<DTO_Carrera_Response> carreraResponses = new ArrayList<>();
        for (ModalidadCarrera carrera : modalidadCarreras) {
            Carrera carrera1 = carreraRepository.getReferenceById(carrera.getCodCarrera());
            Modalidad modalidad = modalidadRepository.getReferenceById(carrera.getIdModalidad());
            TipoCarrera tipoCarrera = carrera.getTipoCarrera();
            DTO_Carrera_Response dtoCarreraResponse = DTO_Carrera_Response.builder()
                    .cod(carrera1.getCod())
                    .nombre_carrera(carrera1.getNombre())
                    .id_modalidad(modalidad.getId())
                    .nombre_modalidad(modalidad.getNombre())
                    .id_tcarrera(tipoCarrera.getId())
                    .nombre_tcarrera(tipoCarrera.getNombre())
                    .build();
            carreraResponses.add(dtoCarreraResponse);
        }

        return carreraResponses;
    }

    public Carrera getCarrera(String codigo) {
        return carreraRepository.findByCod(codigo)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada con el código: " + codigo));
    }

    public Carrera updateCarrera(String codigo, DTO_Carrera dtoCarrera) {
        Carrera carrera = getCarrera(codigo);

        if (dtoCarrera.getCod() != null) {
            carrera.setCod(dtoCarrera.getCod());
        }

        if (dtoCarrera.getNombre() != null) {
            carrera.setNombre(dtoCarrera.getNombre());
        }

        return carreraRepository.save(carrera);
    }

    public List<DTO_Materias> getMateriasByCarreraCodigo(String codCarrera) {
        List<CarreraMateria> carreraMaterias = carreraMateriaRepository.findByCodCarrera(codCarrera);
        List<DTO_Materias> materias = new ArrayList<>();

        for (CarreraMateria carreraMateria : carreraMaterias) {
            Materia materia = materiaRepository.findById(carreraMateria.getCodMateria())
                    .orElseThrow(() -> new RuntimeException("Materia no encontrada con el código: " + carreraMateria.getCodMateria()));
            DTO_Materias dtoMateria = DTO_Materias.builder()
                    .cod_materia(materia.getCod())
                    .nombre_materia(materia.getNombre())
                    .build();
            materias.add(dtoMateria);
        }

        return materias;
    }
}
