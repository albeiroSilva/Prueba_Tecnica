package com.core.prueba_tecnica.Repositories;

import com.core.prueba_tecnica.Models.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}