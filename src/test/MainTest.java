package test;

import DAO.CitaDao;
import DAO.GeneralDao;
import control.MenuControl;
import modelo.Cita;
import vista.MenuVista;
import vista.RegistroCitaVista;

/**
 *
 * @author migue
 */
public class MainTest {
    public static void main(String[] args) {
        CitaDao c = new CitaDao();
        Cita cita = new Cita("a","a","a");
        c.SetCitaCarnet("manolo","hepers genital", "26/131/231");
        c.Agregar(cita, "a1.txt");
    }
    
}
