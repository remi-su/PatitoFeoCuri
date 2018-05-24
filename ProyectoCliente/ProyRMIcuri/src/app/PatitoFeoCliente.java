/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import modulo.Pelicula;
import modulo.Usuario;
import modulo.Asiento;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 *
 * @author Equipo: 
 *          - Samuel Ake Tello
 *          - Miguel G.Canton Tec
 *          - Carlos Augusto Poot Novelo
 *          - Daniel Baas Colonia
 *          - Rafael Rodriguez Guzmán
 * 
 */

public class PatitoFeoCliente {
    
    public boolean insertarNuevoUsuario(String nombre, String clave){
        Usuario usuarioNuevo = new Usuario(nombre, clave);
        try {
            Registry miRegistro = LocateRegistry.getRegistry("127.0.0.1",1234);
            IRemotePatito patitoRemoto = (IRemotePatito)miRegistro.lookup("PatitoFeo:Service");
            patitoRemoto.saveUser(usuarioNuevo);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            return false;
        }
        return true;
    }
    
    public boolean ingresarSistema(String nombre, String clave){
        Usuario usuarioNuevo = new Usuario(nombre, clave);
        Usuario usuarioBuscado = null;
        try {
            Registry miRegistro = LocateRegistry.getRegistry("127.0.0.1",1234);
            IRemotePatito patitoRemoto = (IRemotePatito)miRegistro.lookup("PatitoFeo:Service");
            usuarioBuscado = patitoRemoto.findUser(usuarioNuevo);
            if (usuarioBuscado != null){
                if (usuarioBuscado.getUsuario().compareTo(nombre) == 0 && usuarioBuscado.getClave().compareTo(clave) == 0){
                    return true;
                }   else    {
                    return false;
                }
            }   else    {
                return false;
            }
            
        } catch (Exception ex) {
            return false;
        }
    }
    
    public ArrayList<Pelicula> buscarPeliculas (){
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
        try {
            Registry miRegistro = LocateRegistry.getRegistry("127.0.0.1",1234);
            IRemotePatito patitoRemoto = (IRemotePatito)miRegistro.lookup("PatitoFeo:Service");
            listaPeliculas = patitoRemoto.findMovies();
        } catch (Exception ex) {
            return null;
        }
        return listaPeliculas;
    }
    
    public ArrayList<Asiento> buscarAsientos (String clavePelicula){
        ArrayList<Asiento> listaAsientos = new ArrayList<>();
        try {
            Registry miRegistro = LocateRegistry.getRegistry("127.0.0.1",1234);
            IRemotePatito patitoRemoto = (IRemotePatito)miRegistro.lookup("PatitoFeo:Service");
            listaAsientos = patitoRemoto.findSeat(clavePelicula);
        } catch (Exception ex) {
            return null;
        }
        
        return listaAsientos;
    }
    
    public boolean seleccionarAsiento(Asiento asientoSeleccionado){
        
        try {
            Registry miRegistro = LocateRegistry.getRegistry("127.0.0.1",1234);
            IRemotePatito patitoRemoto = (IRemotePatito)miRegistro.lookup("PatitoFeo:Service");
            patitoRemoto.crearAsiento(asientoSeleccionado);
        } catch (Exception ex) {
            System.out.println("Error en la creacion del asiento");
            return false;
        }
        return true;
    }
    
    public boolean cancelarAsiento(Asiento asientoCancelado){
        try {
            Registry miRegistro = LocateRegistry.getRegistry("127.0.0.1",1234);
            IRemotePatito patitoRemoto = (IRemotePatito)miRegistro.lookup("PatitoFeo:Service");
            patitoRemoto.eliminarAsiento(asientoCancelado);
        } catch (Exception ex) {
            return false;
        }
        return true; 
    }
    
    public boolean confirmarAsientos(ArrayList<Asiento> listaAsientos){
        try {
            Registry miRegistro = LocateRegistry.getRegistry("127.0.0.1",1234);
            IRemotePatito patitoRemoto = (IRemotePatito)miRegistro.lookup("PatitoFeo:Service");

            for (int i = 0; i < listaAsientos.size(); i++) {
                listaAsientos.get(i).setEstado(1);
                patitoRemoto.selectSeat(listaAsientos.get(i));
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    
    
}
