package com.core.prueba_tecnica.Repositories;

import java.util.Date;
import java.util.List;

import com.core.prueba_tecnica.Models.Cita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CitaRepository extends JpaRepository<Cita, Integer> {

    // @Query("SELECT c FROM Cita c WHERE c.fechaCita BETWEEN ?1 AND ?2 ")
    // public List<Cita> findByAllDataBetween(Date fechaInicio, Date fechaFin);
}