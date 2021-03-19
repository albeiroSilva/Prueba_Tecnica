package com.core.prueba_tecnica.JPAUnitTest;

import com.core.prueba_tecnica.Models.Paciente;
import com.core.prueba_tecnica.Repositories.PacienteRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class JPAUnitTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Test
    public void should_find_no_pacientes_if_repository_is_empty() {
        List<Paciente> pacientes = pacienteRepository.findAll();

        assertThat(pacientes.size(), is(equalTo(4)));
    }

    @Test
    public void should_find_all_pacientes() {
        Paciente pac1 = new Paciente();
        pac1.setNombre("pac1");
        pac1.setDescripcion("descrip pac1");
        entityManager.persist(pac1);

        Paciente pac2 = new Paciente();
        pac2.setNombre("pac2");
        pac2.setDescripcion("descrip pac2");
        entityManager.persist(pac2);

        Paciente pac3 = new Paciente();
        pac3.setNombre("pac3");
        pac3.setDescripcion("descrip pac3");
        entityManager.persist(pac3);

        List<Paciente> pacientes = pacienteRepository.findAll();

        assertThat(pacientes.size(), is(equalTo(7)));
    }

}