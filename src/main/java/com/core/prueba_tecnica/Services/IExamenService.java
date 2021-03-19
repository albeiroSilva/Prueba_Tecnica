package com.core.prueba_tecnica.Services;

import java.util.List;

import com.core.prueba_tecnica.Models.Examen;

public interface IExamenService {

    public Examen saveExamen(Examen examen);

    public List<Examen> findAllExamenes();
}