/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.rmi.server.*;
import java.rmi.*;
import java.util.ArrayList;
import modulo.*;
import DAO.*;
import java.sql.SQLException;

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

public class PatitoObject extends UnicastRemoteObject implements IRemotePatito{
    
    public PatitoObject() throws RemoteException {
        super();
    }

    @Override
    public int saveUser(Usuario u) {
        DAOUsuario usuarioBaseDatos = new DAOUsuario();
        
        try {
            usuarioBaseDatos.insertar(u);
        } catch (SQLException ex) {
            System.out.println("Error en el registro del Usuario");
            return 0;
        }
        
        return 1;
    }

    @Override
    public Usuario findUser(Usuario u) {
        DAOUsuario usuarioBaseDatos = new DAOUsuario();
        Usuario usuarioConsultado = null;
        
        try {
            usuarioConsultado = usuarioBaseDatos.consultar(u.getUsuario());
        } catch (SQLException ex) {
            System.out.println("Error en la consulta del Usuario");
            return null;
        }
        
        return usuarioConsultado;
    }

    @Override
    public ArrayList<Pelicula> findMovies() {
        DAOPelicula peliculaBaseDatos = new DAOPelicula();
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
        
        try {
            listaPeliculas = peliculaBaseDatos.consultar();
        } catch (SQLException ex) {
            System.out.println("Error en la busqueda de la peliculas");
            return null;
        }
        return listaPeliculas;
    }

    @Override
    public ArrayList<Asiento> findSeat(String clavePelicula) throws RemoteException {
        DAOAsiento asientoBaseDatos = new DAOAsiento();
        ArrayList<Asiento> listaAsientos = new ArrayList<>();
        
        try {
            listaAsientos = asientoBaseDatos.consultar(clavePelicula);
        } catch (SQLException ex) {
            System.out.println("Error en la busqueda de asientos");
            return null;
        }
        return listaAsientos;
    }

    @Override
    public int selectSeat(Asiento a) {
        DAOAsiento asientoBaseDatos = new DAOAsiento();
        
        try {
            asientoBaseDatos.modificar(a);
        } catch (SQLException ex) {
            System.out.println("Error en el cambio del asiento");
            return 0;
        }
        return 1;
    }

    @Override
    public boolean eliminarAsiento(Asiento a) throws RemoteException {
        DAOAsiento asientoBaseDatos = new DAOAsiento();
        
        try {
            asientoBaseDatos.eliminar(a);
        } catch (SQLException ex) {
            System.out.println("Error en la eliminacion del asiento");
            return false;
        }
        return true;
    }

    @Override
    public boolean crearAsiento(Asiento a) throws RemoteException {
        DAOAsiento asientoBaseDatos = new DAOAsiento();
        
        try {
            asientoBaseDatos.crear(a);
        } catch (SQLException ex) {
            System.out.println("Error en la creacion del asiento");
            return false;
        }
        return true;
    }
    
}
