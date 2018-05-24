package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modulo.Usuario;



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
        
public class DAOUsuario {

    private final static String LINK_MYSQL= "jdbc:mysql://localhost/patitofeo";
    private final static String PASSWORD ="";
    private final static String USUARIO ="root";
    
    public DAOUsuario(){
    
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

    
    public void insertar (Usuario usuario) throws SQLException {
        Connection conexion = crearConexion();
        String orden = "INSERT INTO `usuarios`(`usuario`, `clave`) VALUES "
                + "('"+ usuario.getUsuario() +"','"+ usuario.getClave()+"')"; 

        System.out.println(orden);
        Statement sentencia = conexion.createStatement();
        sentencia.executeUpdate(orden);
        sentencia.close();
        conexion.close();
    }
    
    public Usuario consultar(String nombreUsuario) throws SQLException{
        Connection conexion = crearConexion();
        String orden = "SELECT * FROM `usuarios` where usuario = '"+ nombreUsuario + "'";
        System.out.println(orden);
        
        Statement sentencia = conexion.createStatement();
        ResultSet rs= sentencia.executeQuery(orden);
        Usuario usuario = null;
        if (rs.next()){
            usuario= new Usuario(rs.getString("usuario"),rs.getString("clave"));
        }
        
        
        
        sentencia.close();
        conexion.close();
        
        
        return usuario;
    }
}