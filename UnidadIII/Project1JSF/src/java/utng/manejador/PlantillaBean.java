package utng.manejador;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import utng.modelo.Paciente;

import utng.modelo.Usuario;

/**
 *
 * @author Irbing
 */
@ManagedBean
@ViewScoped
public class PlantillaBean implements Serializable{

    public void checkLogin(){
        try{
            FacesContext context = 
                    FacesContext.getCurrentInstance();
            Paciente paciente = 
                    (Paciente)context.getExternalContext()
                            .getSessionMap().get("paciente");
            if(paciente == null){
                context.getExternalContext()
                        .redirect("login.xhtml");
            }
        }catch(Exception e){
            
        }
    }
}