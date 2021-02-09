package control;

import DAO.CitaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Cita;
import modelo.Cliente;
import vista.RegistroCitaVista;

/**
 *
 * @author migue
 */
public class RegistroCitaControl implements ActionListener{
    private String dia, mes, anio;
    private boolean flag;
    private Cita cita;
    private CitaDao citadao;
    private RegistroCitaVista registrocitavista;   
    
    public RegistroCitaControl(Cita cita, CitaDao citadao, RegistroCitaVista registrocitavista) {  
        this.flag = false;
        this.cita = cita;
        this.citadao = citadao;
        this.registrocitavista = registrocitavista;
        
        this.registrocitavista.getBregistrar().addActionListener(this);
        this.registrocitavista.getBlimpiar().addActionListener(this);
        this.registrocitavista.getBsalir().addActionListener(this);       
    }
    
    public void actionPerformed(ActionEvent evento){
        if(registrocitavista.getBregistrar() == evento.getSource()){
        
            
            if(registrocitavista.getTdoctor().getText().equals("")){
                registrocitavista.getAdoctor().setEnabled(true);
                flag = true;
            } else {
                registrocitavista.getAdoctor().setEnabled(false);
            }
        
            if(registrocitavista.getTmotivo().getText().equals("")){
                registrocitavista.getAmotivo().setEnabled(true);
                flag = true;              
            }else {
                registrocitavista.getAmotivo().setEnabled(false);
            }
            
            dia = registrocitavista.getTdia().getText();
            mes = registrocitavista.getTmes().getText();
            anio = registrocitavista.getTanio().getText();
            
            if(chequeoFecha(dia, mes, anio)){
                registrocitavista.getAfecha().setEnabled(true);
                flag = true;
            } else {
                registrocitavista.getAfecha().setEnabled(false);
            }
            
            if(flag == false){
                cita.setFecha(dia + "/" + mes + "/" + anio);
                cita.setMotivo(registrocitavista.getTmotivo().getText());
                cita.setNombreMedico(registrocitavista.getTdoctor().getText());
                
                if(citadao.Agregar(cita, registrocitavista.getTid().getText()) == true){
                    registrocitavista.getAid().setEnabled(true);
                    registrocitavista.getAexito().setEnabled(false);
                } else {
                    registrocitavista.getAexito().setEnabled(true);
                    registrocitavista.getAid().setEnabled(false);
                }
            }   
            
            flag = false;                                          
        }
        
        if(registrocitavista.getBlimpiar() == evento.getSource()){
            registrocitavista.getTmotivo().setText("");
            registrocitavista.getTdoctor().setText("");
            registrocitavista.getTid().setText("");          
            registrocitavista.getTdia().setText("");
            registrocitavista.getTmes().setText("");
            registrocitavista.getTanio().setText("");
        }
        
        if(registrocitavista.getBsalir() == evento.getSource()){
            registrocitavista.dispose();
        }
    }
    
    public boolean chequeoFecha(String dia, String mes, String anio){
        Date fecha = new Date();
        SimpleDateFormat diafecha = new SimpleDateFormat("dd");
        SimpleDateFormat mesfecha = new SimpleDateFormat("MM");
        SimpleDateFormat aniofecha = new SimpleDateFormat("yyyy");
        int imes, idia, ianio;
        
        idia = Integer.parseInt(diafecha.format(fecha));
        imes = Integer.parseInt(mesfecha.format(fecha));
        ianio = Integer.parseInt(aniofecha.format(fecha));   
              
        if(mes.equals("yyyy") || anio.equals("")){
            return true;
        } else if(Integer.parseInt(anio) < ianio){
            return true;
        }
        
        if(mes.equals("mm") || mes.equals("")){
            return true;
        } else if(Integer.parseInt(mes) < imes || Integer.parseInt(mes) > 12){
            return true;
        }
        
        if(dia.equals("dd") || dia.equals("")){
            return true;
        } else if(Integer.parseInt(dia) < idia || Integer.parseInt(dia) > 31){
            return true;
        }
        
        return false;
    }
    
    
}
