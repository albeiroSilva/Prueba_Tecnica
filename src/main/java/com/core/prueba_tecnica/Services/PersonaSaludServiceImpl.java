package com.core.prueba_tecnica.Services;

import java.util.List;

import com.core.prueba_tecnica.Models.PersonalSalud;
import com.core.prueba_tecnica.Repositories.PersonaSaludRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaSaludServiceImpl implements IPersonaSaludService {

    @Autowired
    private PersonaSaludRepository objPersonalSaludRepository;

    @Override
    public PersonalSalud savePersonalSalud(PersonalSalud personaSalud) {
        return objPersonalSaludRepository.save(personaSalud);
    }

    @Override
    public List<PersonalSalud> findAllPersonaSalud() {
        return objPersonalSaludRepository.findAll();
    }

}