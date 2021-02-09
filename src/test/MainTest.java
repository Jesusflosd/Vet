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
        MenuVista menu = new MenuVista();
        Cita cita = new Cita();
        CitaDao citadao = new CitaDao();
        
        RegistroCitaControl rcitaControl = new RegistroCitaControl(cita, citadao, rcita);
        MenuControl menucontrol = new MenuControl(rcita, menu);
        menu.setVisible(true);
    }    
}
