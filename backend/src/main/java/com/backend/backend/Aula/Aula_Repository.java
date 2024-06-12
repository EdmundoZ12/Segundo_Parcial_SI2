package com.backend.backend.Aula;

import com.backend.backend.Modulo.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Aula_Repository extends JpaRepository<Aula,Integer> {
    boolean existsByNro(Integer nro);
    List<Aula> findByModulo(Modulo modulo);

    @Query("SELECT COUNT(a) > 0 FROM Aula a WHERE a.nro = :nro AND a.modulo.id = :moduloId")
    boolean existsByNroAndModuloId(@Param("nro") Integer nro, @Param("moduloId") Integer moduloId);
}
