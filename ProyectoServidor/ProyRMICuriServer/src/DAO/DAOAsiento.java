/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.DriverManager;
import java.sql.SQLException;
import modulo.Asiento;



/**
 *
 * @author Equipo: 
 *          - Samuel Ake Tello
 *          - Miguel G.Canton Tec
 *          - Carlos Augusto Poot Novelo
 *          - Daniel Baas Colonia
 *          - Rafael Rodriguez
 * 
 */
        
public class DAOAsiento {

    private final static String LINK_MYSQL= "jdbc:mysql://localhost/patitofeo";
    private final static String PASSWORD ="";
    private final static String USUARIO ="root";
    
    public DAOAsiento(){
    
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e){
            System.out.println("no hay acceso a la base de datos, drivers malinstalados");
        }    
        
    }
    
    
    private Connection crearConexion() {
        Connection conexion=null;
        try {
            
            conexion = (Connection) DriverManager.getConnection (LINK_MYSQL,USUARIO, PASSWORD);
            System.out.println("conexion realizada");
            
        } catch (SQLException ex) {
            System.out.println("Error en la Conexion");
        }
        return conexion;
    }

    
    public void modificar(Asiento asiento) throws SQLException {
        Connection conexion = crearConexion();
        String orden = "UPDATE `asientospelicula` SET `estado` = " + 1 + " WHERE `asientospelicula`.`clavePelicula` = '"
                +asiento.getClavePelicula() + "' AND `asientospelicula`.`numeroAsiento` = " + asiento.getNumeroAsiento();

        System.out.println(orden);
        Statement sentencia = conexion.createStatement();
        sentencia.executeUpdate(orden);
        sentencia.close();
        conexion.close();
    }
    
    public ArrayList<Asiento>  consultar(String clavePelicula) throws SQLException{
        ArrayList<Asiento> listaAsientos = new ArrayList<Asiento>();
        Connection conexion = crearConexion();
        String orden = "SELECT * FROM `asientospelicula`  where clavePelicula = '"+ clavePelicula + "'";
        System.out.println(orden);
        
        Statement sentencia = conexion.createStatement();
        ResultSet rs= sentencia.executeQuery(orden);
        
        while (rs.next()) {
            Asiento asiento= new Asiento(
                    rs.getString("clavePelicula"),rs.getInt("numeroAsiento"),
                    rs.getInt("estado"),rs.getString("usuario"));
            listaAsientos.add(asiento);
        }
        
        sentencia.close();
        conexion.close();
        
        
        return listaAsientos;
    }
    
    public void crear(Asiento asiento) throws SQLException{
        Connection conexion = crearConexion();
        String orden = "INSERT INTO `asientospelicula`(`clavePelicula`, `numeroAsiento`, `estado`, `usuario`) VALUES "
                + " ( '" + asiento.getClavePelicula() + "'," + asiento.getNumeroAsiento() + "," + asiento.getEstado() 
                + ", '" + asiento.getNombreCliente() + "')"; 

        System.out.println(orden);
        Statement sentencia = conexion.createStatement();
        sentencia.executeUpdate(orden);
        sentencia.close();
        conexion.close();
    }
    
    public void eliminar(Asiento asiento) throws SQLException{
        Connection conexion = crearConexion();
        String orden = "DELETE FROM `asientospelicula` WHERE 'clavePelicula' = '" + asiento.getClavePelicula() + "'" 
                + "'numeroAsiento' =" + asiento.getNumeroAsiento(); 

        System.out.println(orden);
        Statement sentencia = conexion.createStatement();
        sentencia.executeUpdate(orden);
        sentencia.close();
        conexion.close();
    }
    
}