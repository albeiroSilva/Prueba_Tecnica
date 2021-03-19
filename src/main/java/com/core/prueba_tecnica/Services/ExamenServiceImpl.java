package com.core.prueba_tecnica.Services;

import java.util.List;

import com.core.prueba_tecnica.Models.Examen;
import com.core.prueba_tecnica.Repositories.ExamenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamenServiceImpl implements IExamenService {

    @Autowired
    private ExamenRepository objExamenRepository;

    @Override
    public Examen saveExamen(Examen examen) {
        return objExamenRepository.save(examen);
    }

    @Override
    public List<Examen> findAllExamenes() {
        return objExamenRepository.findAll();
    }

}