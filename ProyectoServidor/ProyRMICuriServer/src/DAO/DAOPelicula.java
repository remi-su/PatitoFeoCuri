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
import java.util.logging.Level;
import java.util.logging.Logger;
import modulo.Pelicula;

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
        
public class DAOPelicula {

    private final static String LINK_MYSQL= "jdbc:mysql://localhost/patitofeo";
    private final static String PASSWORD ="";
    private final static String USUARIO ="root";
    
    public DAOPelicula(){
    
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

    

    
    public ArrayList<Pelicula> consultar() throws SQLException{
        Connection conexion = crearConexion();
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
        String orden = "SELECT * FROM peliculas";
        System.out.println(orden);
        
        Statement sentencia = conexion.createStatement();
        ResultSet rs= sentencia.executeQuery(orden);
        
        
        while (rs.next()) {
            Pelicula pelicula= new Pelicula(rs.getString("clavePelicula"),
                    rs.getString("nombrePelicula"),rs.getString("urlImagen"));
            listaPeliculas.add(pelicula);
        }
        
        sentencia.close();
        conexion.close();
        
        return listaPeliculas;
    }
}