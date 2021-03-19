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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "personal_de_la_salud")
@PrimaryKeyJoinColumn(name = "id_personasalud")
public class PersonalSalud extends Persona {

    @Column(name = "numero_tarjeta_profesional")
    @ApiModelProperty(value = "idCita", example = "100201")
    private Integer numeroTarjetaProfesional;

    @Column(name = "especialidad")
    @ApiModelProperty(value = "idCita", example = "Neurocirujano")
    private String especialidad;

    @ApiModelProperty(value = "idCita", example = "Médico Especialista")
    @Column(name = "tipo_de_personal")
    private String tipo;

    @ApiModelProperty(value = "examenes", hidden = true)
    @JsonIgnore
    @JsonIgnoreProperties(value = { "objPersonalSalud" }, allowSetters = true)
    @OneToMany(mappedBy = "objPersonalSalud", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Examen> examenes;

    @ApiModelProperty(value = "citas", hidden = true)
    @JsonIgnore
    @JsonIgnoreProperties(value = { "objPersonalSalud" }, allowSetters = true)
    @OneToMany(mappedBy = "objPersonalSalud", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cita> citas;

    public PersonalSalud() {
        this.examenes = new ArrayList<>();
        this.citas = new ArrayList<>();
    }

    /**
     * @return Integer return the numeroTarjetaProfesional
     */
    public Integer getNumeroTarjetaProfesional() {
        return numeroTarjetaProfesional;
    }

    /**
     * @param numeroTarjetaProfesional the numeroTarjetaProfesional to set
     */
    public void setNumeroTarjetaProfesional(Integer numeroTarjetaProfesional) {
        this.numeroTarjetaProfesional = numeroTarjetaProfesional;
    }

    /**
     * @return String return the especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * @return String return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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

}