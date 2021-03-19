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
@Table(name = "examenes")
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_examen")
    @ApiModelProperty(value = "idExamen", hidden = true)
    private Integer id;

    @Column(name = "nombre_examen")
    @ApiModelProperty(value = "idCita", example = "Resonancia magnética")
    private String nombreExamen;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_examen")
    @ApiModelProperty(value = "fechaEXamen", example = "2021-03-17")
    private Date fechaExamen;

    @JsonIgnoreProperties(value = { "examenes" }, allowSetters = true)
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente objPaciente;

    @ManyToOne
    @JoinColumn(name = "id_personasalud")
    private PersonalSalud objPersonalSalud;

    public Examen() {
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
     * @return String return the nombreExamen
     */
    public String getNombreExamen() {
        return nombreExamen;
    }

    /**
     * @param nombreExamen the nombreExamen to set
     */
    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    /**
     * @return Date return the fechaExamen
     */
    public Date getFechaExamen() {
        return fechaExamen;
    }

    /**
     * @param fechaExamen the fechaExamen to set
     */
    public void setFechaExamen(Date fechaExamen) {
        this.fechaExamen = fechaExamen;
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