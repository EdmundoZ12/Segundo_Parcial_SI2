package com.backend.backend.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Usuario_Repository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByNroRegistro(String nro_registro);
}
