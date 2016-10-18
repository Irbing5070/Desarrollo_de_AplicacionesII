/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.DoctorDAO;
import utng.modelo.Doctor;

/**
 *
 * @author Irbing
 */
@ManagedBean
@SessionScoped
public class DoctorBean implements Serializable{
    private List<Doctor> doctores;
    private Doctor doctor;

    public DoctorBean() {
    }

    public List<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(List<Doctor> doctores) {
        this.doctores = doctores;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public String listar(){
        DoctorDAO dao = new DoctorDAO();
        try{
            doctores = dao.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Doctores";
    }
    
    public String eliminar(){
    DoctorDAO dao = new DoctorDAO();
    try{
        dao.delete(doctor);
        doctores = dao.getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
    return "Eliminar";
    }
    
    public String iniciar(){
        doctor = new Doctor();
        return "Iniciar";
    }
    
    public String guardar(){
        DoctorDAO dao = new DoctorDAO();
        try{
            if(doctor.getIdDoctor()!=0){
                dao.update(doctor);
            }else{
                dao.insert(doctor);
            }
            doctores = dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
        return "Cancelar";
    }
    
    public String editar(Doctor doctor){
        this.doctor = doctor;
        return "Editar";
    }            
}
