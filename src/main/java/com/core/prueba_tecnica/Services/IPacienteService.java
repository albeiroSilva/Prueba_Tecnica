package com.core.prueba_tecnica.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.core.prueba_tecnica.Models.Paciente;

public interface IPacienteService {

    public Paciente savePaciente(Paciente paciente);

    public List<Paciente> findAllPacientes();

    public Optional<Paciente> findPacienteById(Integer id);

    public List<Paciente> findPacientesByDate(String fecha1, String fecha2);
}