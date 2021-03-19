package com.core.prueba_tecnica.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.core.prueba_tecnica.Models.PersonalSalud;
import com.core.prueba_tecnica.Services.IPersonaSaludService;

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
public class PersonaSaludController {

    @Autowired
    private IPersonaSaludService servicePersonalSalud;

    @PostMapping("/savePersonalSalud")
    @ApiOperation(value = "Crear un personal de la salud", notes = "Retorna el personal de la salud creado, el campo id no es necesario agregarlo, se crea automáticamente")
    public ResponseEntity<?> crearPersonalSalud(@RequestBody PersonalSalud personalSalud, BindingResult result) {

        Map<String, Object> response = new HashMap<>();

        PersonalSalud objPersonalSalud;

        if (result.hasErrors()) {

            List<String> listaErrores = new ArrayList<>();

            for (FieldError error : result.getFieldErrors()) {
                listaErrores.add("El campo '" + error.getField() + "‘ " + error.getDefaultMessage());
            }

            response.put("errors", listaErrores);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

        }

        try {
            objPersonalSalud = this.servicePersonalSalud.savePersonalSalud(personalSalud);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción en la base de datos");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El Personal de la salud ha sido creado con éxito!");
        response.put("Personal de la salud: ", objPersonalSalud);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Muestra todos los personales de salud creados", notes = "Retorna una lista con todos las personas que pertenecen al área de la salud")
    @GetMapping("/personalSalud")
    public ResponseEntity<?> mostrarPersonalSalud() {
        return ResponseEntity.ok(this.servicePersonalSalud.findAllPersonaSalud());

    }

}