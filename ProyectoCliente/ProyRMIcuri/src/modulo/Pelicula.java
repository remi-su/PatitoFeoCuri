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

public class Pelicula implements Serializable{
    private String clavePelicula;
    private String nombrePelicula;
    private String urlPelicula;

    public Pelicula() {
    }

    public Pelicula(String clavePelicula, String nombrePelicula, String urlPelicula) {
        this.clavePelicula = clavePelicula;
        this.nombrePelicula = nombrePelicula;
        this.urlPelicula = urlPelicula;
    }

    public String getClavePelicula() {
        return clavePelicula;
    }

    public void setClavePelicula(String clavePelicula) {
        this.clavePelicula = clavePelicula;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getUrlPelicula() {
        return urlPelicula;
    }

    public void setUrlPelicula(String urlPelicula) {
        this.urlPelicula = urlPelicula;
    }
    
    
}
