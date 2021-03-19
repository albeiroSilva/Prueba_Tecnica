package com.core.prueba_tecnica.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "pacientes")
@PrimaryKeyJoinColumn(name = "id_paciente")
@ApiModel("PacienteModel")
public class Paciente extends Persona {

    @ApiModelProperty(value = "Descripcion del paciente", required = true, example = "paciente con morbolidades")
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    // @JsonIgnore
    @ApiModelProperty(value = "examenes", hidden = true)
    @JsonIgnoreProperties(value = { "objPaciente" }, allowSetters = true)
    @OneToMany(mappedBy = "objPaciente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Examen> examenes;

    // @JsonIgnore
    @ApiModelProperty(value = "citas", hidden = true)
    @JsonIgnoreProperties(value = { "objPaciente" }, allowSetters = true)
    @OneToMany(mappedBy = "objPaciente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cita> citas;

    public Paciente() {
        this.examenes = new ArrayList<>();
        this.citas = new ArrayList<>();
    }

    /**
     * @return String return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return List<Examen> return the examenes
     */

    public List<Examen> getExamenes() {
        return examenes;
    }

    /**
     * @param examenes the examenes to set
     */
    public void setExamenes(List<Examen> examenes) {
        this.examenes = examenes;
    }

    /**
     * @return List<Cita> return the citas
     */
    public List<Cita> getCitas() {
        return citas;
    }

    /**
     * @param citas the citas to set
     */
    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public Paciente(String descripcion) {
        this.descripcion = descripcion;
    }

}