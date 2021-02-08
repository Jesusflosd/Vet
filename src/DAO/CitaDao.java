package DAO;
import java.io.File;
import java.io.FileWriter;
import modelo.Cita;

/**
 *
 * @author migue
 */
public class CitaDao extends GeneralDao<Cita>{
    private File[] listapaciente;
    private FileWriter fw;
    private String pacientecarnet;
    public CitaDao(){
    }

    public boolean Agregar(Cita cita, String ID) {
        listapaciente = getCarpetaPaciente().listFiles();
        
        for(int i = 0; i < listapaciente.length;i++){
            //verifica si existe el ID, si es asi, agrega la cita al carnet y retorna true
           if(ID.equals(listapaciente[i].getName())){
               pacientes = new File(getCarpetaPaciente() + "\\" +listapaciente[i].getName());
               System.out.println(listapaciente[i].getName());
               
               try{                  
                   fw = new FileWriter(pacientes, true);
                   fw.write(GetCitaCarnet() + "\n");
                   
                   fw.close();
               }catch(Exception io){
                   
               }        
                          
           }else{
               return false;
           }
        }
        
        return true;       
    }
    
    public void SetCitaCarnet(String medico, String motivo, String Fecha){
        pacientecarnet = medico +":" + motivo + ":" + Fecha;
    }
    
    public String GetCitaCarnet(){
        return pacientecarnet;
    }
}
