/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.dao;

import java.util.List;
import mx.edu.utng.model.Credito;

/**
 *
 * @author Irbing Martinez Garcia
 */
public interface CreditoDAO {
    void agregarCredito(Credito credito);
    void borraCredito (int idCredito);
    void cambiarCredito (Credito credito);
    List<Credito> desplegarCreditos();
    Credito elegirCredito (int idCredito);
    
}
