package mx.edu.utng.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.utng.dao.CreditoDAO;
import mx.edu.utng.dao.CreditoDAOImp;
import mx.edu.utng.model.Credito;

public class CreditoController extends HttpServlet{
    private static final String LISTA_CREDITOS = "/lista_creditos.jsp";
    private static final String AGREGAR_O_CAMBIAR = "/credito.jsp";
    private CreditoDAO dao ;
    
    public CreditoController(){
        dao = new CreditoDAOImp();    
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("borrar")){
            forward = LISTA_CREDITOS;
            int idCredito = Integer.parseInt(
            request.getParameter("idCredito"));
            dao.borraCredito(idCredito);
            request.setAttribute("creditos", dao.desplegarCreditos());
        }else if (action.equalsIgnoreCase("cambiar")){
            forward = AGREGAR_O_CAMBIAR;
             int idCredito = Integer.parseInt(
            request.getParameter("idCredito"));
             Credito credito = dao.elegirCredito(idCredito);
             request.setAttribute("credito", credito);
        }else if (action.equalsIgnoreCase("agregar")){
            forward = AGREGAR_O_CAMBIAR;
        }else{
            forward = LISTA_CREDITOS;
            request.setAttribute("creditos", dao.desplegarCreditos());
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response); 
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Credito credito = new Credito();
        credito.setNombre(request.getParameter("nombre"));
        credito.setFechaExpedicion(request.getParameter("fechaExpedicion"));
        credito.setTipo(request.getParameter("tipo"));
        String idCredito = request.getParameter("idCredito");
        
        if(idCredito==null || idCredito.isEmpty()){
                dao.agregarCredito(credito);
            }else{
            credito.setIdCredito(Integer.parseInt(idCredito));
            dao.cambiarCredito(credito);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_CREDITOS);
        request.setAttribute("creditos", dao.desplegarCreditos());
        view.forward(request, response);  
    }

}
