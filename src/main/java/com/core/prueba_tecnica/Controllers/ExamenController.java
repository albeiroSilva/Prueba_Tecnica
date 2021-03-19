package com.core.prueba_tecnica.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.core.prueba_tecnica.Models.Examen;
import com.core.prueba_tecnica.Services.IExamenService;

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
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class ExamenController {

    @Autowired
    private IExamenService serviceExamen;

    @ApiOperation(value = "Crea un Examen", notes = "Retorna la Cita ya creada")
    @PostMapping("/saveExamen")
    public ResponseEntity<?> crearPaciente(@RequestBody final Examen examen, final BindingResult result) {

        final Map<String, Object> response = new HashMap<>();

        Examen objExamen;

        if (result.hasErrors()) {

            final List<String> listaErrores = new ArrayList<>();

            for (final FieldError error : result.getFieldErrors()) {
                listaErrores.add("El campo '" + error.getField() + "‘ " + error.getDefaultMessage());
            }

            response.put("errors", listaErrores);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

        }

        try {
            objExamen = this.serviceExamen.saveExamen(examen);

        } catch (final DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción en la base de datos");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El Examen ha sido creado con éxito!");
        response.put("Examen", objExamen);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Muestra todos los exámenes creados", notes = "Retorna una lista con tofos los exámenes creados")
    @GetMapping("/examenes")
    public ResponseEntity<?> showUsers() {
        return ResponseEntity.ok(this.serviceExamen.findAllExamenes());

    }
}