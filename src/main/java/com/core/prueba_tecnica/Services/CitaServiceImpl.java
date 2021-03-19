package com.core.prueba_tecnica.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.core.prueba_tecnica.Models.Cita;
import com.core.prueba_tecnica.Repositories.CitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaServiceImpl implements ICitaService {

    @Autowired
    private CitaRepository objCitaRepository;

    @Override
    public List<Cita> findAllCitas() {
        return objCitaRepository.findAll();
    }

    @Override
    public List<Cita> findCitaByDate(List<Cita> citas, String fechaInicio, String fechaFin) {
        List<Cita> citasPaciente = citas;
        List<Cita> citasPorFecha = new ArrayList<>();

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        Date fecha1;
        Date fecha2;
        try {
            fecha1 = formato.parse(fechaInicio);
            fecha2 = formato.parse(fechaFin);

            for (int i = 0; i < citasPaciente.size(); i++) {
                if (citasPaciente.get(i).getFechaCita().after(fecha1)
                        && citasPaciente.get(i).getFechaCita().before(fecha2)) {

                    citasPorFecha.add(citasPaciente.get(i));
                }
                System.out.println(citasPaciente.get(i).getFechaCita());
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return citasPorFecha;
    }

    @Override
    public Cita saveCita(Cita cita) {
        return objCitaRepository.save(cita);
    }

}