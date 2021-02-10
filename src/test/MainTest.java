package test;
import DAO.*;
import control.*;
import modelo.*;
import vista.*;

/**
 *
 * @author migue
 */
public class MainTest {
    public static void main(String[] args) {
        RegistroCitaVista rcita = new RegistroCitaVista();
        RegistroUsuarioVista ruv = new RegistroUsuarioVista();
        LoginVista loginvista = new LoginVista();
        Usuario usuario = new Usuario();
        UsuarioDao usuariodao = new UsuarioDao();
        MenuVista menuvista = new MenuVista(); 
        Cita cita = new Cita();
        CitaDao citadao = new CitaDao();
        ClienteDao clienteDao = new ClienteDao();
        CarnetVista carnetVista = new CarnetVista();
        
        RegistroCitaControl rcitaControl = new RegistroCitaControl(cita, citadao, rcita);
        MenuControl menucontrol = new MenuControl(rcita, menuvista, loginvista, carnetVista);
        RegistroUsuarioControl reguscontrol = new RegistroUsuarioControl(ruv, usuario, usuariodao, loginvista);
        LoginControl logincontrol = new LoginControl(loginvista, usuario, usuariodao, ruv, menuvista);
        CarnetControl carnetControl = new CarnetControl(carnetVista, clienteDao);
        loginvista.setVisible(true);
        
    }    
}
