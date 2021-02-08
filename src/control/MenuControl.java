package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.MenuVista;
import vista.RegistroCitaVista;

/**
 *
 * @author migue
 */
public class MenuControl implements ActionListener {
    private RegistroCitaVista citavista;
    private MenuVista menuvista;
    
    public MenuControl(RegistroCitaVista citavista, MenuVista menuvista){
        this.citavista = citavista;
        this.menuvista = menuvista;
        
        this.menuvista.getBregistroconsulta().addActionListener(this);
        this.menuvista.getBsalir().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent evento){
        if(menuvista.getBregistroconsulta() == evento.getSource()){
            citavista.setVisible(true);
        }
        
    }
}
