package app;

import View.EscogerLugarJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
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

public class ControladorEscogerLugar implements ActionListener{

    private EscogerLugarJFrame escogerLugarFrame;
    private String clavePelicula;
    private String nombreUsuario;
    private hiloCargarAsientos hiloCarga;
    private PatitoFeoCliente patitoCliente;
    private ArrayList<Asiento> listaAsientosAConfirmar;
    
    public ControladorEscogerLugar(String clavePelicula, String nombreUsuario) {
        setEscogerLugarFrame(new EscogerLugarJFrame());
        getEscogerLugarFrame().setVisible(true);
        setClavePelicula(clavePelicula);
        setNombreUsuario(nombreUsuario);
        setPatitoCliente(new PatitoFeoCliente());
        getEscogerLugarFrame().nombreUsuariojLabel.setText(nombreUsuario);
        setHiloCarga(new hiloCargarAsientos(getEscogerLugarFrame(),getClavePelicula(),getNombreUsuario()));
        setListaAsientosAConfirmar(new ArrayList<>());
        inicializarActionListeners();
    }
    
    private void inicializarActionListeners(){
        for (int i = 0; i < getEscogerLugarFrame().getListaAsientos().size() ; i++) {
            getEscogerLugarFrame().getListaAsientos().get(i).addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int numeroAsiento = Integer.parseInt(((JLabel)e.getComponent()).getName());
                        Asiento nuevoAsiento = new Asiento(getClavePelicula(),numeroAsiento,2,getNombreUsuario());
                        System.out.println(((JLabel)e.getComponent()).getName());
                        boolean bandera = getPatitoCliente().seleccionarAsiento(nuevoAsiento);
                        if (bandera){
                            getListaAsientosAConfirmar().add(nuevoAsiento);
                        }
                        
                    }
            });
        }
        
        getEscogerLugarFrame().cerrarSesionjLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                getPatitoCliente().confirmarAsientos(getListaAsientosAConfirmar());
                getHiloCarga().stop();
                getEscogerLugarFrame().dispose();
            }
        });
    }

    public ArrayList<Asiento> getListaAsientosAConfirmar() {
        return listaAsientosAConfirmar;
    }

    public void setListaAsientosAConfirmar(ArrayList<Asiento> listaAsientosAConfirmar) {
        this.listaAsientosAConfirmar = listaAsientosAConfirmar;
    }
    

    public PatitoFeoCliente getPatitoCliente() {
        return patitoCliente;
    }

    public void setPatitoCliente(PatitoFeoCliente patitoCliente) {
        this.patitoCliente = patitoCliente;
    }

    public EscogerLugarJFrame getEscogerLugarFrame() {
        return escogerLugarFrame;
    }

    public void setEscogerLugarFrame(EscogerLugarJFrame escogerLugarFrame) {
        this.escogerLugarFrame = escogerLugarFrame;
    }

    public String getClavePelicula() {
        return clavePelicula;
    }

    public void setClavePelicula(String clavePelicula) {
        this.clavePelicula = clavePelicula;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public hiloCargarAsientos getHiloCarga() {
        return hiloCarga;
    }

    public void setHiloCarga(hiloCargarAsientos hiloCarga) {
        this.hiloCarga = hiloCarga;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
