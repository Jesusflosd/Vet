package test;

import DAO.DaoGeneral;
import control.MenuControl;
import vista.MenuVista;
import vista.RegistroCitaVista;

/**
 *
 * @author migue
 */
public class MainTest {
    public static void main(String[] args) {
        MenuVista me = new MenuVista();
        RegistroCitaVista rc = new RegistroCitaVista();
        MenuControl m = new MenuControl(rc, me);
        me.setVisible(true);      
    }
    
}
