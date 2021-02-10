package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.CarnetVista;
import vista.LoginVista;
import vista.MenuVista;
import vista.RegistroCitaVista;

/**
 *
 * @author migue
 */
public class MenuControl implements ActionListener{
    private RegistroCitaVista citavista;
    private MenuVista menuvista;
    private LoginVista loginvista;
    private CarnetVista carnetVista;
    
    public MenuControl(RegistroCitaVista citavista, MenuVista menuvista, LoginVista loginvista, CarnetVista carnetVista){
        this.citavista = citavista;
        this.menuvista = menuvista;
        this.loginvista = loginvista;
        this.carnetVista = carnetVista;

        this.menuvista.getBregistroconsulta().addActionListener(this);
        this.menuvista.getBcarnet().addActionListener(this);
        this.menuvista.getBsalir().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent evento){
        if(menuvista.getBregistroconsulta() == evento.getSource()){
            citavista.setVisible(true);
        }

        if(menuvista.getBcarnet() == evento.getSource()){
            this.carnetVista.setVisible(true);
        }
        
        if(menuvista.getBsalir() == evento.getSource()){
            this.menuvista.dispose();
            this.loginvista.setVisible(true);
        }
        
    }
}
