package com.backend.backend.Carrera;

import com.backend.backend.Carrera.DTO.DTO_Carrera;
import com.backend.backend.Modalidad.Modalidad_Repository;
import com.backend.backend.Modalidad_Carrera.ModalidadCarrera;
import com.backend.backend.Modalidad_Carrera.ModalidadCarrera_Repository;
import com.backend.backend.Tipo_Carrera.TipoCarrera;
import com.backend.backend.Tipo_Carrera.TipoCarrera_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Carrera_Service {

    private final Carrera_Repository carreraRepository;
    private final Modalidad_Repository modalidadRepository;
    private final TipoCarrera_Repository tipoCarreraRepository;
    private final ModalidadCarrera_Repository modalidadCarreraRepository;

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

    public List<Carrera> getAllCarreras() {
        return carreraRepository.findAll();
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
}
