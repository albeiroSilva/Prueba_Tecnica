package com.core.prueba_tecnica.Repositories;

import com.core.prueba_tecnica.Models.PersonalSalud;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaSaludRepository extends JpaRepository<PersonalSalud, Integer> {

}