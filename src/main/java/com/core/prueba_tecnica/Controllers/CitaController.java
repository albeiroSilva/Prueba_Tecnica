package com.core.prueba_tecnica.Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.core.prueba_tecnica.Models.Cita;
import com.core.prueba_tecnica.Services.ICitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class CitaController {

    @Autowired
    private ICitaService serviceCita;

    @PostMapping("/saveCita")
    @ApiOperation(value = "Crea una Cita", notes = "Retorna la cita creada")
    public ResponseEntity<?> crearPaciente(@RequestBody Cita cita, BindingResult result) {

        Map<String, Object> response = new HashMap<>();

        Cita objCita;

        if (result.hasErrors()) {

            List<String> listaErrores = new ArrayList<>();

            for (FieldError error : result.getFieldErrors()) {
                listaErrores.add("El campo '" + error.getField() + "‘ " + error.getDefaultMessage());
            }

            response.put("errors", listaErrores);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

        }

        try {
            objCita = this.serviceCita.saveCita(cita);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción en la base de datos");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "La Cita ha sido creada con éxito!");
        response.put("Cita", objCita);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Muestra todas las citas creadas", notes = "Retorna una lista con todas las citas creadas")
    @GetMapping("/citas")
    public ResponseEntity<?> mostrarCitas() {
        return ResponseEntity.ok(this.serviceCita.findAllCitas());

    }

}