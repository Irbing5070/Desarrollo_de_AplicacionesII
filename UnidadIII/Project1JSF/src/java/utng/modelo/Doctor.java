/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Irbing
 */
@Entity 
@Table(name = "doctor")
public class Doctor implements Serializable{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    @Column(name = "id_doctor")
    private Long idDoctor;
    @Column(length = 30)
    private String nombre;
    private String especialidad;
    private String cedula_profesional;
    
    public Doctor(){
        this.idDoctor = 0L;
    }

    public Long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCedula_profesional() {
        return cedula_profesional;
    }

    public void setCedula_profesional(String cedula_profesional) {
        this.cedula_profesional = cedula_profesional;
    }

}
