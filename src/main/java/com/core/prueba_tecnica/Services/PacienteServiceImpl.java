package com.core.prueba_tecnica.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.core.prueba_tecnica.Models.Paciente;
import com.core.prueba_tecnica.Repositories.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private PacienteRepository objPacienteRepository;

    @Override
    public List<Paciente> findAllPacientes() {
        return objPacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> findPacienteById(Integer id) {
        return objPacienteRepository.findById(id);
    }

    @Override
    public List<Paciente> findPacientesByDate(String fecha1, String fecha2) {

        return null;
    }

    @Override
    public Paciente savePaciente(Paciente paciente) {
        return objPacienteRepository.save(paciente);
    }

}