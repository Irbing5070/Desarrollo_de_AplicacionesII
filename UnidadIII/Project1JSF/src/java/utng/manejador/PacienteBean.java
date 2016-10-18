package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import utng.datos.DoctorDAO;
import utng.datos.PacienteDAO;
import utng.modelo.Doctor;
import utng.modelo.Paciente;

/**
 *
 * @author Irbing
 */
@ManagedBean (name = "pacienteBean") 
@SessionScoped
public class PacienteBean implements Serializable{

    private List<Paciente>pacientes;
    private Paciente paciente;
    private List<Doctor>doctores;
    
    public PacienteBean(){
        paciente = new Paciente();
        paciente.setDoctor(new Doctor());
    }

    public List<Doctor> getDoctores() {
        return doctores;
    }    

    public void setDoctores(List<Doctor> doctores) {
        this.doctores = doctores;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public String listar(){
        PacienteDAO dao = new PacienteDAO();
        try{
            pacientes = dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Pacientes";
    }
    public String eliminar(){
        PacienteDAO dao = new PacienteDAO();
        try{
            dao.delete(paciente);
            pacientes = dao.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Eliminar";
    }
    public String iniciar(){
        paciente = new Paciente();
        paciente.setDoctor(new Doctor());
        try{
            doctores = new DoctorDAO().getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Iniciar";
    }
    public String guardar(){
        PacienteDAO dao = new PacienteDAO();
        try{
            if(paciente.getIdPaciente()!=0){
                dao.update(paciente);
            }else{
                dao.insert(paciente);
            }
            pacientes = dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Guardar";
    }
    public String cancelar(){        
        return "Cancelar";
    }
    public String editar(Paciente paciente){
        this.paciente = paciente;
        try{
            doctores = new DoctorDAO().getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Editar";
    }
    public String login(){
        paciente = new PacienteDAO().login(this.paciente);
        if(paciente != null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("paciente", paciente);
            return "Correcto";
        }else{
            paciente = new Paciente();
            return "Incorrecto";
        }
    }

}
