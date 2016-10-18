/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utng.modelo.Paciente;

/**
 *
 * @author Irbing
 */
public class PacienteDAO extends DAO<Paciente>{

    public PacienteDAO(){
        super(new Paciente());
    }
    
    public Paciente getOneByID (Paciente paciente) throws HibernateException{
        return super.getOneById(paciente.getIdPaciente());
    }
    
    public Paciente login(Paciente paciente){
        List<String> parametros = new ArrayList<String>();  
        List<Object>valores = new ArrayList<Object>();
        parametros.add("nombrePaciente");
        parametros.add("contrasenia");
        valores.add(paciente.getNombrePaciente());
        valores.add(paciente.getContrasenia());
        
        paciente = query("SELECT u FROM "
        +modelo.getClass().getName()
        +" u WHERE u.nombrePaciente=:nombrePaciente "
        + "AND u.contrasenia=:contrasenia", 
                parametros, valores);
        return paciente;
    }
}
