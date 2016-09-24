/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.prendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.edu.utng.prendas.model.Prenda;
import mx.edu.utng.prendas.util.UtilDB;

/**
 *
 * @author Sofía 
 */
public class PrendaDAOImp implements PrendaDAO{

    private Connection connection;
    
    public PrendaDAOImp(){
        connection = UtilDB.getConnection();
    }
    
    @Override
    public void agregarPrenda(Prenda prenda) {
        try {
          String query = "INSERT INTO prendas (descripcion, color, "
                  + " stand, precio) VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, prenda.getDescripcion());
            ps.setString(2, prenda.getColor());
            ps.setString(3, prenda.getStand());
            ps.setInt(4, prenda.getPrecio());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarPrenda(int idPrenda) {
        try {
             String query = "DELETE FROM prendas WHERE id_prenda = ?";
             PreparedStatement ps = connection.prepareCall(query);
             ps.setInt(1, idPrenda);
             ps.executeUpdate();
             ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarPrenda(Prenda prenda) {
    try {
          String query = "UPDATE prendas SET descripcion= ?, "
                  + " color= ?, stand=?, precio=? WHERE "
                  + " id_prenda= ?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, prenda.getDescripcion());
            ps.setString(2, prenda.getColor());
            ps.setString(3, prenda.getStand());
            ps.setInt(4, prenda.getPrecio());
            ps.setInt(5, prenda.getIdPrenda());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Prenda> desplegarPrenda() {
        List<Prenda> prendas = new ArrayList<Prenda>();
        try{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM prendas");
            while (resultSet.next()) {
              Prenda prenda = new Prenda(
              resultSet.getInt("id_prenda"),
              resultSet.getString("descripcion"),
              resultSet.getString("color"),
              resultSet.getString("stand"),
              resultSet.getInt("precio"));
              prendas.add(prenda);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return prendas;
    }

    @Override
    public Prenda elegirPrenda(int idPrenda) {
       Prenda prenda = new Prenda();
        try{
        PreparedStatement statement = 
                connection.prepareStatement(
                        "SELECT * FROM prendas WHERE "
                                + " id_prenda = ?");
        statement.setInt(1, idPrenda);
        ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
              prenda.setIdPrenda(resultSet.getInt("id_prenda"));
                      
              prenda.setDescripcion(resultSet.getString("descripcion"));
              prenda.setColor(resultSet.getString("color"));
              prenda.setStand(resultSet.getString("stand"));
              prenda.setPrecio(resultSet.getInt("precio"));
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return prenda;
    }
    
    
}
