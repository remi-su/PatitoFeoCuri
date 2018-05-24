/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import modulo.Pelicula;
import modulo.Usuario;
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

public interface IRemotePatito extends Remote {
    public int saveUser(Usuario u) throws RemoteException;
    public Usuario findUser(Usuario u) throws RemoteException;
    public ArrayList<Pelicula> findMovies() throws RemoteException;
    public ArrayList<Asiento> findSeat(String clavePelicula) throws RemoteException;
    public int selectSeat(Asiento a) throws RemoteException;
    public boolean eliminarAsiento (Asiento a)throws RemoteException;
    public boolean crearAsiento (Asiento a) throws RemoteException;
}
