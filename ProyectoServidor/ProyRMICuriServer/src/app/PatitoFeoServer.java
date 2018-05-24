/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author neko__000
 */
public class PatitoFeoServer {

    public PatitoFeoServer() {
        try {
            
            Registry miRegistry = LocateRegistry.createRegistry(1234);
            PatitoObject patitoServer = new PatitoObject();
            miRegistry.rebind("PatitoFeo:Service", patitoServer);
            System.out.println("El Servidor esta corriendo");
        } catch (Exception ex) {
            System.out.println("Error en la creacion del Servidor" + ex);
        }
    }
    
    public static void main(String[] args) {
        new PatitoFeoServer();
    }
    
    
}
