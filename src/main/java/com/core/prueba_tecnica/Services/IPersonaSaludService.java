package com.core.prueba_tecnica.Services;

import java.util.List;

import com.core.prueba_tecnica.Models.PersonalSalud;

public interface IPersonaSaludService {

    public PersonalSalud savePersonalSalud(PersonalSalud personaSalud);

    public List<PersonalSalud> findAllPersonaSalud();
}