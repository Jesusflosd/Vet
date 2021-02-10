package modelo;
/**
 *
 * @author migue
 */
public class Usuario {
    private String nombre;
    private String nombreusuario;
    private String contraseña;
    private String correo;
    private String telefono;
    private String edad;
    
    public Usuario(){        
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEdad() {
        return edad;
    }
    
    
    
        

    
    
        
}
