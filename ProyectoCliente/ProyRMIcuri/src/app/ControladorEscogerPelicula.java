package app;

import View.EscogerPeliculaJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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

public class ControladorEscogerPelicula implements ActionListener{

    private EscogerPeliculaJFrame escogerPelicula;
    private PatitoFeoCliente patitoCliente;
    private ArrayList<Pelicula> listaPeliculas;
    private String nombreUsuario;
    
    public ControladorEscogerPelicula(String nombreUsuario) {
        setEscogerPelicula(new EscogerPeliculaJFrame());
        getEscogerPelicula().setVisible(true);
        setPatitoCliente(new PatitoFeoCliente());
        setListaPeliculas(getPatitoCliente().buscarPeliculas());
        getEscogerPelicula().nombreUsuariojLabel.setText(nombreUsuario);
        setNombreUsuario(nombreUsuario);
        inicializarActionListeners();
    }

    private void inicializarActionListeners(){
        getEscogerPelicula().JLabelCoco.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new ControladorEscogerLugar(getListaPeliculas().get(0).getClavePelicula(),getNombreUsuario());
                }
        });
        
        getEscogerPelicula().JFerdinand.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new ControladorEscogerLugar(getListaPeliculas().get(1).getClavePelicula(),getNombreUsuario());
                }
        });
        
        getEscogerPelicula().JIT.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new ControladorEscogerLugar(getListaPeliculas().get(2).getClavePelicula(),getNombreUsuario());
                }
        });
        
        getEscogerPelicula().JJumanji.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new ControladorEscogerLugar(getListaPeliculas().get(3).getClavePelicula(),getNombreUsuario());
                }
        });
        getEscogerPelicula().cerrarSesionjLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    getEscogerPelicula().dispose();
                    new ControladorLogin();
                    
                }
        });
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    
    public EscogerPeliculaJFrame getEscogerPelicula() {
        return escogerPelicula;
    }

    public void setEscogerPelicula(EscogerPeliculaJFrame escogerPelicula) {
        this.escogerPelicula = escogerPelicula;
    }

    public PatitoFeoCliente getPatitoCliente() {
        return patitoCliente;
    }

    public void setPatitoCliente(PatitoFeoCliente patitoCliente) {
        this.patitoCliente = patitoCliente;
    }

    public ArrayList<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
