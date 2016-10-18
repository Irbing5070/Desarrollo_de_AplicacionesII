/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Irbing
 */
@Entity 
@Table (name= "paciente")
public class Paciente implements Serializable{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_paciente")
    private Long idPaciente;
    @Column(name = "nombre_paciente", length = 20)
    private String nombrePaciente;
    @Column(length = 40)
    private String apellidosPaciente;
    @Column(length = 40)
    private String contrasenia;
    @ManyToOne
    @JoinColumn (name = "id_doctor")
    private Doctor doctor;
    
    public Paciente(Long idPaciente, String nombrePaciente, String apelidosPaciente, String contrasenia, Doctor doctor){
        super ();
        this.idPaciente = idPaciente;
        this.nombrePaciente = nombrePaciente;
        this.apellidosPaciente = apelidosPaciente;
        this.contrasenia = contrasenia;
        this.doctor = doctor;
    }
    
    public Paciente(){
        this.idPaciente = 0L;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidosPaciente() {
        return apellidosPaciente;
    }

    public void setApellidosPaciente(String apellidosPaciente) {
        this.apellidosPaciente = apellidosPaciente;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}