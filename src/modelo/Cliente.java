package modelo;

/**
 *
 * @author migue
 */
public class Cliente {
    private String nombre;
    private String telefono;
    private String correo;
    private Mascota mascota;
    
    public Cliente(String nombre, String telefono, String correo, String nombreM, String edad, String peso, String raza, String id){
        mascota = new Mascota(nombreM, edad, peso, raza, id);
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }  
    
}
