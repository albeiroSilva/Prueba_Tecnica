package com.core.prueba_tecnica.Services;

import java.util.Date;
import java.util.List;

import com.core.prueba_tecnica.Models.Cita;

public interface ICitaService {

    public Cita saveCita(Cita cita);

    public List<Cita> findAllCitas();

    public List<Cita> findCitaByDate(List<Cita> citas, String fechaInicio, String fechaFin);
}