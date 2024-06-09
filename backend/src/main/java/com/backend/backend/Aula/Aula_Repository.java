package com.backend.backend.Aula;

import com.backend.backend.Modulo.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Aula_Repository extends JpaRepository<Aula,Integer> {
    boolean existsByNro(Integer nro);
    List<Aula> findByModulo(Modulo modulo);
}
