/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Doctor;

/**
 *
 * @author Irbing
 */
public class DoctorDAO extends DAO<Doctor>{

    public DoctorDAO(){
        super(new Doctor());
    }
    
    public Doctor getOneById(Doctor doctor) throws HibernateException{
        return super.getOneById(
                doctor.getIdDoctor());
    }
}
