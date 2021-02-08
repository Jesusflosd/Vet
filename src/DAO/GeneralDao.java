package DAO;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author migue
 */
public abstract class GeneralDao<T>{
    private String Pathgeneral;
    private String carpetaPrincicalPath;
    private String usuariosPath;
    private String pacientesPath;
    private File carpetaRaiz;
    private File carpetaUsuario;
    private File carpetaPaciente;
    private File archvioUsuario;
    protected File Pacientes;
    
    public GeneralDao(){
        this.Pathgeneral = System.getProperty("user.home");
        generarRepositorio();
    }
    
    public void generarRepositorio(){
        //PATH de las carpetas
        carpetaPrincicalPath = Pathgeneral + "\\Documents\\Veterinaria";
        usuariosPath = carpetaPrincicalPath + "\\Usuarios";
        pacientesPath = carpetaPrincicalPath + "\\Pacientes";
        
        carpetaRaiz = new File(carpetaPrincicalPath);
        carpetaUsuario = new File(usuariosPath);
        carpetaPaciente = new File(pacientesPath);
        
        //Verifica si existe la carpeta raiz: de no ser, la crea junto a las demas
        if(!carpetaRaiz.exists()){
            carpetaRaiz.mkdir();
            carpetaUsuario.mkdir();
            carpetaPaciente.mkdir();
        }
        
        //Genera el archivo de las cuentas
        generarArchivos(usuariosPath, pacientesPath);       
    }
    
    public void generarArchivos(String CarpetaUsuarios,String CarpetaPaciente){
        archvioUsuario = new File(CarpetaUsuarios + "\\Usuarios.txt");
        
        try{
            //Verifica la existencia, de lo contrario, lo crea
            if(!archvioUsuario.exists()){
                archvioUsuario.createNewFile();
            }                   
        } catch(IOException e){
            e.printStackTrace();
        }
    }       
    
}
