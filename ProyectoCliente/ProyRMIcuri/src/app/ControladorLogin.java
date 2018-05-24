package app;

import View.LoginJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class ControladorLogin implements ActionListener{
    private LoginJFrame loginFrame;
    private PatitoFeoCliente patitoCliente;
    
    public ControladorLogin() {
        setLoginFrame(new LoginJFrame());
        getLoginFrame().setVisible(true);
        getLoginFrame().setLocationRelativeTo(null);
        setPatitoCliente(new PatitoFeoCliente());
        
        inicializarActionListeners();
    }

    public LoginJFrame getLoginFrame() {
        return loginFrame;
    }

    public void setLoginFrame(LoginJFrame loginFrame) {
        this.loginFrame = loginFrame;
    }
    private void inicializarActionListeners(){
        getLoginFrame().iniciarButtonjLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    
                    iniciarSesion();
                }

        });
        
        getLoginFrame().crearButtonjLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("holiwis");
                    registrarUsuario();
                }

        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    private void registrarUsuario(){
        String nombreNuevo = "";
        String claveNueva = "";
        boolean esRegistroExitoso = false;
        
        nombreNuevo = getLoginFrame().crearUsuarioJTextField.getText();
        claveNueva = getLoginFrame().crearContraJTextField.getText();
        esRegistroExitoso = getPatitoCliente().insertarNuevoUsuario(nombreNuevo,claveNueva);
        
        if (esRegistroExitoso){
            System.out.println("Registro Exitoso");
        }   else    {
            System.out.println("Registro Fallido");
        }
    }
    
    private void iniciarSesion(){
        String nombre = "";
        String clave = "";
        boolean esInicioExitoso=  false;
        nombre = getLoginFrame().iniciarUsuarioJTextField.getText();
        clave = getLoginFrame().iniciarContraJTextField.getText();
        esInicioExitoso = getPatitoCliente().ingresarSistema(nombre, clave);
        
        if (esInicioExitoso){
            getLoginFrame().dispose();
            new ControladorEscogerPelicula(nombre);
        }   else    {
            System.out.println("Error en la conexion");
        }
    }

    public PatitoFeoCliente getPatitoCliente() {
        return patitoCliente;
    }

    public void setPatitoCliente(PatitoFeoCliente patitoCliente) {
        this.patitoCliente = patitoCliente;
    }
    
    
    
    
}
