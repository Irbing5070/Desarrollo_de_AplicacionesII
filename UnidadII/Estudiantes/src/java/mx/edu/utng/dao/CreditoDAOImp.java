package mx.edu.utng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.edu.utng.model.Credito;
import mx.edu.utng.util.UtilDB;

public class CreditoDAOImp implements CreditoDAO{
    
    private Connection connection;
    
    public CreditoDAOImp(){
        connection = UtilDB.getConnection();
    }

    @Override
    public void agregarCredito(Credito credito) {
        try{
            String query = "INSERT INTO creditos(nombre, fecha_expedicion, tipo) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, credito.getNombre());
            ps.setString(2, credito.getFechaExpedicion());
            ps.setString(3, credito.getTipo());
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void borraCredito(int idCredito) {
        try{
            String query = "DELETE FROM creditos WHERE id_credito = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idCredito);
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarCredito(Credito credito) {
        try{
            String query = "UPDATE creditos SET nombre = ?, fecha_expedicion = ?, tipo = ? "
                    + "WHERE id_credito = ?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, credito.getNombre());
            ps.setString(2, credito.getFechaExpedicion());
            ps.setString(3, credito.getTipo());
            ps.setInt(4, credito.getIdCredito());
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Credito> desplegarCreditos() {
        List<Credito> creditos = new ArrayList<Credito>();
        try{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM creditos");
            while (resultSet.next()) {
                Credito credito = new Credito(
                resultSet.getInt("id_credito"), 
                resultSet.getString("nombre"),
                resultSet.getString("fecha_expedicion"),
                resultSet.getString("tipo"));
                creditos.add(credito);
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return creditos;
    }

    @Override
    public Credito elegirCredito(int idCredito) {
        Credito credito = new Credito();
        try{
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM creditos"
                + " WHERE id_credito = ?");
        statement.setInt(1, idCredito);
        
        ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                credito.setIdCredito(resultSet.getInt("id_credito")); 
                credito.setNombre(resultSet.getString("nombre"));
                credito.setFechaExpedicion(resultSet.getString("fecha_expedicion"));
                credito.setTipo(resultSet.getString("tipo"));
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return credito;
    }
            
}
