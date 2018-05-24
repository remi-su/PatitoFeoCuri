/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo;

import java.io.Serializable;

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

public class Asiento implements Serializable{
    private int idAsiento;
    private String clavePelicula;
    private int numeroAsiento;
    private int estado;
    private String nombreCliente;

    public Asiento() {
    }

    public Asiento(String clavePelicula, int numeroAsiento, int estado, String nombreCliente) {
        this.clavePelicula = clavePelicula;
        this.numeroAsiento = numeroAsiento;
        this.estado = estado;
        this.nombreCliente = nombreCliente;
    }

    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public String getClavePelicula() {
        return clavePelicula;
    }

    public void setClavePelicula(String clavePelicula) {
        this.clavePelicula = clavePelicula;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    
}
