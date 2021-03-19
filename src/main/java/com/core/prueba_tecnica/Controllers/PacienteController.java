package com.core.prueba_tecnica.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.core.prueba_tecnica.Models.Cita;
import com.core.prueba_tecnica.Models.Paciente;
import com.core.prueba_tecnica.Services.ICitaService;
import com.core.prueba_tecnica.Services.IPacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class PacienteController {

    @Autowired
    private IPacienteService servicePaciente;

    @Autowired
    private ICitaService serviceCita;

    @PostMapping("/savePaciente")
    @ApiOperation(value = "Crea un Paciente", notes = "Retorna el Paciente creado, el campo id no es necesario agregarlo, se crea automáticamente")
    public ResponseEntity<?> crearPaciente(@RequestBody Paciente paciente, BindingResult result) {

        Map<String, Object> response = new HashMap<>();

        Paciente objPaciente;

        if (result.hasErrors()) {

            List<String> listaErrores = new ArrayList<>();

            for (FieldError error : result.getFieldErrors()) {
                listaErrores.add("El campo '" + error.getField() + "‘ " + error.getDefaultMessage());
            }

            response.put("errors", listaErrores);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

        }

        try {
            objPaciente = this.servicePaciente.savePaciente(paciente);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción en la base de datos");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El Paciente ha sido creado con éxito!");
        response.put("Paciente", objPaciente);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/pacientes")
    @ApiOperation(value = "Muestra todos los pacientes creados", notes = "Retorna una lista con todos los pacientes creados")
    public ResponseEntity<?> mostrarPacientes() {
        return ResponseEntity.ok(this.servicePaciente.findAllPacientes());

    }

    @GetMapping("/citasPorFecha/{id}")
    @ApiOperation(value = "Muestra las citas que tiene un paciente específico en un rango de fechas", notes = "Retorna las citas que tiene un paciente en un rango de fechas")
    public ResponseEntity<?> mostrarPacientesPorFecha(
            @ApiParam(value = "id", required = true, example = "1") final @PathVariable Integer id,
            @ApiParam(value = "fechaInicio", required = true, example = "2021-04-18") final @RequestParam("fechaInicio") String fechaInicio,
            @ApiParam(value = "fechaFin", required = true, example = "2021-08-19") final @RequestParam("fechaFin") String fechaFin) {

        Map<String, Object> response = new HashMap<>();
        Paciente objPaciente = null;

        try {
            Optional<Paciente> o = this.servicePaciente.findPacienteById(id);
            if (o.isPresent()) {
                objPaciente = o.get();
            }
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (objPaciente == null) {
            response.put("mensaje", "El Paciente ID: " + id + " no existe en la base de datos!");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        List<Cita> citasPaciente = objPaciente.getCitas();
        List<Cita> citasEntreFechas = this.serviceCita.findCitaByDate(citasPaciente, fechaInicio, fechaFin);

        objPaciente.setCitas(citasEntreFechas);

        return new ResponseEntity<Paciente>(objPaciente, HttpStatus.OK);
    }

}