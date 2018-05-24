/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import View.EscogerLugarJFrame;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modulo.Asiento;

/**
 *
 * @author neko__000
 */
public class hiloCargarAsientos extends Thread{
    private EscogerLugarJFrame ventanaAsientos;
    private PatitoFeoCliente cliente;
    private String clavePelicula;
    private String nombreUsuario;

    public hiloCargarAsientos(EscogerLugarJFrame ventanaAsientos, String clavePelicula, String nombreUsuario) {
        this.ventanaAsientos = ventanaAsientos;
        setCliente(new PatitoFeoCliente());
        setClavePelicula(clavePelicula);
        setNombreUsuario(nombreUsuario);
        this.start();
    }
    
    
    @Override
    public void run(){
        while(true){
            try {
                ArrayList<Asiento> listaAsientos = getCliente().buscarAsientos(getClavePelicula());
                boolean banderaTempo = true;
                for (int i = 0; i < 100; i++) {
                    banderaTempo = true;
                    for (int j = 0; j < listaAsientos.size(); j++) {
                        if (listaAsientos.get(j).getNumeroAsiento() == i){
                            banderaTempo = false;
                            break;
                        }
                    }
                    if (banderaTempo){
                        cambiarModoAsiento(i,1);
                    }
                }
                for (int i = 0; i < listaAsientos.size(); i++) {
                    //Si esta vendido
                    if (listaAsientos.get(i).getEstado() == 1){
                        //Y le pertenece al mismo usuario
                        System.out.println("Entra");
                        if (listaAsientos.get(i).getNombreCliente().compareTo(getNombreUsuario()) == 0){
                            //Entonces El asiento se colore de color Gris
                            cambiarModoAsiento(listaAsientos.get(i).getNumeroAsiento(),4);
                            //bloquearAsiento(listaAsientos.get(i).getNumeroAsiento());
                        }   else    {
                            //Sino entonces le pertenece a otro usuario, entonces e colorea de rojo
                            cambiarModoAsiento(listaAsientos.get(i).getNumeroAsiento(),2);
                            //bloquearAsiento(listaAsientos.get(i).getNumeroAsiento());
                        }
                    } else  {
                        //Si esta en modo Reservacion, y le pertenmece ese asiento al mismo usuario
                        if (listaAsientos.get(i).getNombreCliente().compareTo(getNombreUsuario()) == 0){
                            //Entonces el asiento se colorea de Negro
                            cambiarModoAsiento(listaAsientos.get(i).getNumeroAsiento(),3);
                        }   else    {
                            //Sino, entonce sotro usuario lo tiene reservado, entonces se colorea de Azul
                            cambiarModoAsiento(listaAsientos.get(i).getNumeroAsiento(),5);
                            //bloquearAsiento(listaAsientos.get(i).getNumeroAsiento());
                        }
                    }
                }
                getVentanaAsientos().JPanelAsientos.updateUI();
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Error:" + ex);
            }
        }
    }
    
    private void bloquearAsiento(int index){
        getVentanaAsientos().getListaAsientos().get(index).setEnabled(false);
    }
    
    private void cambiarModoAsiento(int index, int modo){
        if (modo == 1){
            getVentanaAsientos().getListaAsientos().get(index)
                    .setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/asientoVerde.png")));
        }
        if (modo == 2){
            getVentanaAsientos().getListaAsientos().get(index)
                    .setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/asientoRojo.png")));
        }
        if (modo == 3){
            getVentanaAsientos().getListaAsientos().get(index)
                    .setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/asientoNegro.png")));
        }
        if (modo == 4){
            getVentanaAsientos().getListaAsientos().get(index)
                    .setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/asientoGris.png")));
        }
        if (modo == 5){
            getVentanaAsientos().getListaAsientos().get(index)
                    .setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/asientoAzul.png")));
        }
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public PatitoFeoCliente getCliente() {
        return cliente;
    }

    public void setCliente(PatitoFeoCliente cliente) {
        this.cliente = cliente;
    }

    public EscogerLugarJFrame getVentanaAsientos() {
        return ventanaAsientos;
    }
    
    public void setVentanaAsientos(EscogerLugarJFrame ventanaAsientos) {
        this.ventanaAsientos = ventanaAsientos;
    }

    public String getClavePelicula() {
        return clavePelicula;
    }

    public void setClavePelicula(String clavePelicula) {
        this.clavePelicula = clavePelicula;
    }
    
    
    
    
}
