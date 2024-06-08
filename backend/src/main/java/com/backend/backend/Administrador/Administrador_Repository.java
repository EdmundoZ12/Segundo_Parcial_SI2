package com.backend.backend.Administrador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Administrador_Repository extends JpaRepository<Administrador,String> {
}
