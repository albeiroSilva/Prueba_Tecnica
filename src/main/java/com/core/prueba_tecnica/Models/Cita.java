package com.core.prueba_tecnica.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    @ApiModelProperty(value = "idCita", hidden = true)
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_cita")
    @ApiModelProperty(value = "idCita", example = "2021-03-17")
    private Date fechaCita;

    @JsonIgnoreProperties(value = { "citas" }, allowSetters = true)
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente objPaciente;

    @JsonIgnoreProperties(value = { "citas" }, allowSetters = true)
    @ManyToOne
    @JoinColumn(name = "id_personasalud")
    private PersonalSalud objPersonalSalud;

    public Cita() {
    }

    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return Date return the fechaCita
     */
    public Date getFechaCita() {
        return fechaCita;
    }

    /**
     * @param fechaCita the fechaCita to set
     */
    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    /**
     * @return Paciente return the objPaciente
     */
    public Paciente getObjPaciente() {
        return objPaciente;
    }

    /**
     * @param objPaciente the objPaciente to set
     */
    public void setObjPaciente(Paciente objPaciente) {
        this.objPaciente = objPaciente;
    }

    /**
     * @return PersonalSalud return the objPersonalSalud
     */
    public PersonalSalud getObjPersonalSalud() {
        return objPersonalSalud;
    }

    /**
     * @param objPersonalSalud the objPersonalSalud to set
     */
    public void setObjPersonalSalud(PersonalSalud objPersonalSalud) {
        this.objPersonalSalud = objPersonalSalud;
    }

}